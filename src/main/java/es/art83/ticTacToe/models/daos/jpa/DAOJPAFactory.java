package es.art83.ticTacToe.models.daos.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;

import es.art83.ticTacToe.models.daos.PieceDAO;
import es.art83.ticTacToe.models.daos.SessionDAO;
import es.art83.ticTacToe.models.daos.DAOFactory;
import es.art83.ticTacToe.models.daos.GameDAO;
import es.art83.ticTacToe.models.daos.PlayerDAO;

public class DAOJPAFactory extends DAOFactory {
    private static final String PERSISTENCE_UNIT = "tictactoe";

    private static EntityManagerFactory emf = Persistence
            .createEntityManagerFactory(PERSISTENCE_UNIT);

    public DAOJPAFactory() {
        LogManager.getLogger(DAOJPAFactory.class).info("create Entity Manager Factory");
    }

    public static EntityManagerFactory getEmf() {
        return emf;
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

    @Override
    public PieceDAO getPieceDAO() {
        return new PieceDAOJPA();
    }

}
