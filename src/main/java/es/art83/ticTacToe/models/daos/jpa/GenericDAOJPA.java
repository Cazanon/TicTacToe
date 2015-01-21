package es.art83.ticTacToe.models.daos.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.logging.log4j.LogManager;

import es.art83.ticTacToe.models.daos.GenericDAO;

public class GenericDAOJPA<T, ID> implements GenericDAO<T, ID> {
    private Class<T> persistentClass;

    public GenericDAOJPA(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    @Override
    public void create(T entity) {
        EntityManager entityManager = DAOJPAFactory.getEmf().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
            LogManager.getLogger(GenericDAOJPA.class).info("create: " + entity);
        } catch (Exception e) {
            LogManager.getLogger(GenericDAOJPA.class).error("create: " + e);
            if (entityManager.getTransaction().isActive())
                entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public T read(ID id) {
        EntityManager entityManager = DAOJPAFactory.getEmf().createEntityManager();
        T entity = entityManager.find(persistentClass, id);
        entityManager.close();
        return entity;
    }

    @Override
    public void update(T entity) {
        EntityManager entityManager = DAOJPAFactory.getEmf().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
            LogManager.getLogger(GenericDAOJPA.class).info("update: " + entity);
        } catch (Exception e) {
            LogManager.getLogger(GenericDAOJPA.class).error("update: " + e);
            if (entityManager.getTransaction().isActive())
                entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    // entity debe estar en estado de "Managed"
    @Override
    public void delete(T entity) {
        EntityManager entityManager = DAOJPAFactory.getEmf().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
            LogManager.getLogger(GenericDAOJPA.class).info("delete: " + entity);
        } catch (Exception e) {
            LogManager.getLogger(GenericDAOJPA.class).error("delete: " + e);
            if (entityManager.getTransaction().isActive())
                entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }

    }

    @Override
    public void deleteByID(ID id) {
        T entity = this.read(id);
        if (entity != null)
            this.delete(entity);
    }

    @Override
    public List<T> findAll() {
        EntityManager entityManager = DAOJPAFactory.getEmf().createEntityManager();
        // Se crea un criterio de consulta
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(this.persistentClass);

        // Se establece la clausula FROM
        Root<T> root = criteriaQuery.from(this.persistentClass);

        // Se establece la clausula SELECT
        criteriaQuery.select(root); // criteriaQuery.multiselect(root.get(atr))

        // No existen predicados

        // Se realiza la query
        TypedQuery<T> tq = entityManager.createQuery(criteriaQuery);
        tq.setFirstResult(0); // El primero es 0
        tq.setMaxResults(0); // Se realiza la query, se buscan todos
        List<T> result = tq.getResultList();
        entityManager.close();
        return result;
    }

}
