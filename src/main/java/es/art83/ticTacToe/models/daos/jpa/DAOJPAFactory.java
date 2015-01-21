package es.art83.ticTacToe.models.daos.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;

import es.art83.ticTacToe.models.daos.SessionDAO;
import es.art83.ticTacToe.models.daos.DAOFactory;
import es.art83.ticTacToe.models.daos.GameDAO;
import es.art83.ticTacToe.models.daos.PlayerDAO;

public class DAOJPAFactory extends DAOFactory {
    private static final String PERSISTENCE_UNIT = "tictactoe";

    private EntityManager em;

    public DAOJPAFactory() {
        this.em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT).createEntityManager();
        LogManager.getLogger(DAOJPAFactory.class).info("createEntityManager");
    }

    public EntityManager getEm() {
        if (!em.isOpen()) {
            em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT).createEntityManager();
            LogManager.getLogger(DAOJPAFactory.class).info("createEntityManager");
        }
        return em;
    }

    @Override
    public PlayerDAO getPlayerDAO() {
        return new PlayerDAOJPA();
    }

    @Override
    public GameDAO getGameDAO() {
        return new GameDAOJPA();
    }

    @Override
    public SessionDAO getSessionDAO() {
        return new SessionDAOJPA();
    }

}
