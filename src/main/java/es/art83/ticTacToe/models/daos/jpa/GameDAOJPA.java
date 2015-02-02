package es.art83.ticTacToe.models.daos.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import es.art83.ticTacToe.models.daos.DAOFactory;
import es.art83.ticTacToe.models.daos.GameDAO;
import es.art83.ticTacToe.models.entities.GameEntity;
import es.art83.ticTacToe.models.entities.PlayerEntity;

public class GameDAOJPA extends GenericDAOJPA<GameEntity, Integer> implements GameDAO {

    public GameDAOJPA() {
        super(GameEntity.class);
    }

    @Override
    public List<String> findPlayerGameNames(PlayerEntity player) {
        EntityManager entityManager = DAOJPAFactory.getEmf().createEntityManager();
        // Se crea un criterio de consulta
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<String> query = builder.createQuery(String.class);
        // Se establece la clausula FROM
        Root<GameEntity> root = query.from(GameEntity.class);
        // Se establece la clausula SELECT
        query.select(root.get("name")); // criteriaQuery.multiselect(root.get(atr))
        // Se configura el predicado
        Predicate predicate1 = builder.equal(root.get("playerEntity").as(PlayerEntity.class),
                player);
        Predicate predicate2 = builder.isNotNull(root.get("name").as(String.class));
        // Se establece el WHERE
        query.where(builder.and(predicate1, predicate2));
        // Se crea el resultado
        TypedQuery<String> tq = entityManager.createQuery(query);
        tq.setFirstResult(0);
        tq.setMaxResults(0); // Se buscan todos
        List<String> result = tq.getResultList();
        entityManager.close();
        return result;
    }

    @Override
    public List<GameEntity> findPlayerGames(PlayerEntity player, String gameName) {
        EntityManager entityManager = DAOJPAFactory.getEmf().createEntityManager();
        // Se crea un criterio de consulta
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<GameEntity> query = builder.createQuery(GameEntity.class);
        // Se establece la clausula FROM
        Root<GameEntity> root = query.from(GameEntity.class);
        // Se establece la clausula SELECT
        query.select(root); // criteriaQuery.multiselect(root.get(atr))
        // Se configura el predicado
        Predicate predicate1 = builder.equal(root.get("playerEntity").as(PlayerEntity.class),
                player);
        Predicate predicate2 = builder.equal(root.get("name").as(String.class), gameName);
        Predicate predicate = builder.and(predicate1, predicate2);
        // Se establece el WHERE
        query.where(predicate);
        // Se crea el resultado
        TypedQuery<GameEntity> tq = entityManager.createQuery(query);
        tq.setFirstResult(0);
        tq.setMaxResults(0); // Se buscan todos
        List<GameEntity> result = tq.getResultList();
        entityManager.close();
        return result;
    }

    @Override
    public GameEntity findPlayerGame(PlayerEntity player, String gameNameSelected) {
        List<GameEntity> sessionGames = DAOFactory.getFactory().getSessionDAO()
                .findPlayerGames(player);
        List<GameEntity> playerGames = this.findPlayerGames(player, gameNameSelected);
        for (GameEntity sessionGame : sessionGames) {
            for (GameEntity playerGame : playerGames) {
                if (playerGame.getId() == sessionGame.getId()) {
                    playerGames.remove(playerGame);
                    break;
                }
            }

        }
        assert playerGames.size() == 1;
        return playerGames.get(0);
    }
}
