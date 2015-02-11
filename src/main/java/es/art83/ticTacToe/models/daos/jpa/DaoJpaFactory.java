package es.art83.ticTacToe.models.daos.jpa;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.eclipse.persistence.config.PersistenceUnitProperties;

import es.art83.ticTacToe.models.daos.PieceDao;
import es.art83.ticTacToe.models.daos.SessionDao;
import es.art83.ticTacToe.models.daos.DaoFactory;
import es.art83.ticTacToe.models.daos.GameDao;
import es.art83.ticTacToe.models.daos.PlayerDao;

public class DaoJpaFactory extends DaoFactory {
    private static final String PERSISTENCE_UNIT = "tictactoe";

    private static EntityManagerFactory entityManagerFactory; 

    public DaoJpaFactory() {
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
            LogManager.getLogger(DaoJpaFactory.class).debug("create Entity Manager Factory");
        }
        return entityManagerFactory;
    }

    public static void dropAndCreateTables() {
        Map<String, String> properties = new HashMap<>();
        properties.put(PersistenceUnitProperties.DDL_GENERATION,
                PersistenceUnitProperties.DROP_AND_CREATE);
        entityManagerFactory = Persistence.createEntityManagerFactory("BBDD", properties);
        LogManager.getLogger(DaoJpaFactory.class).debug("create Entity Manager Factory");
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
