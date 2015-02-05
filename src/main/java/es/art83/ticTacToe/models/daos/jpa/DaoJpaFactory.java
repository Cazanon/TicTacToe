package es.art83.ticTacToe.models.daos.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;

import es.art83.ticTacToe.models.daos.PieceDao;
import es.art83.ticTacToe.models.daos.SessionDao;
import es.art83.ticTacToe.models.daos.DaoFactory;
import es.art83.ticTacToe.models.daos.GameDao;
import es.art83.ticTacToe.models.daos.PlayerDao;

public class DaoJpaFactory extends DaoFactory {
    private static final String PERSISTENCE_UNIT = "tictactoe";

    private static EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory(PERSISTENCE_UNIT);

    public DaoJpaFactory() {
        LogManager.getLogger(DaoJpaFactory.class).debug("create Entity Manager Factory");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    @Override
    public PlayerDao getPlayerDao() {
        return new PlayerDaoJpa();
    }

    @Override
    public GameDao getGameDao() {
        return new GameDaoJpa();
    }

    @Override
    public SessionDao getSessionDao() {
        return new SessionDaoJpa();
    }

    @Override
    public PieceDao getPieceDao() {
        return new PieceDaoJpa();
    }

}
