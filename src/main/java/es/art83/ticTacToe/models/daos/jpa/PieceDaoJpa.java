package es.art83.ticTacToe.models.daos.jpa;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import es.art83.ticTacToe.models.daos.PieceDao;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.entities.PieceEntity;

public class PieceDaoJpa extends GenericDaoJpa<PieceEntity, Integer> implements PieceDao {

    public PieceDaoJpa() {
        super(PieceEntity.class);
    }

    
    public void deleteByCoordinate(CoordinateEntity coordinateEntity) {
        EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory().createEntityManager();
        // Se crea un criterio de consulta
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PieceEntity> query = builder.createQuery(PieceEntity.class);
        // Se establece la clausula FROM
        Root<PieceEntity> root = query.from(PieceEntity.class);
        // Se establece la clausula SELECT
        query.select(root);
        // Se configura el predicado
        Predicate predicate = builder.equal(root.get("coordinateEntity").as(CoordinateEntity.class),
                coordinateEntity);
        // Se establece el WHERE
        query.where(predicate);
        // Se crea el resultado
        TypedQuery<PieceEntity> tq = entityManager.createQuery(query);
        PieceEntity pieceEntity = tq.getSingleResult();
        entityManager.close();
        if (pieceEntity != null) {
            this.deleteByID(pieceEntity.getId());
        }
    }

}
