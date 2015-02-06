package es.art83.ticTacToe.models.daos.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import es.art83.ticTacToe.models.daos.SessionDao;
import es.art83.ticTacToe.models.entities.GameEntity;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.models.entities.SessionEntity;

public class SessionDaoJpa extends GenericDaoJpa<SessionEntity, Integer> implements SessionDao {

    public SessionDaoJpa() {
        super(SessionEntity.class);
    }

    @Override
    public List<GameEntity> findPlayerGamesOfSession(PlayerEntity player) {
        EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory().createEntityManager();
        // Se crea un criterio de consulta
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<GameEntity> query = builder.createQuery(GameEntity.class);
        // Se establece la clausula FROM
        Root<SessionEntity> root = query.from(SessionEntity.class);
        // Se establece la clausula SELECT
        query.select(root.get("game")); // criteriaQuery.multiselect(root.get(atr))
        // Se configura el predicado
        Predicate predicate1 = builder.equal(root.get("player").as(PlayerEntity.class), player);
        Predicate predicate2 = builder.isNotNull(root.get("game").as(GameEntity.class));
        // Se establece el WHERE
        query.where(builder.and(predicate1, predicate2));
        // Se crea el resultado
        TypedQuery<GameEntity> tq = entityManager.createQuery(query);
        tq.setFirstResult(0);
        tq.setMaxResults(0); // Se buscan todos
        List<GameEntity> result = tq.getResultList();
        entityManager.close();
        return result;
    }

}
