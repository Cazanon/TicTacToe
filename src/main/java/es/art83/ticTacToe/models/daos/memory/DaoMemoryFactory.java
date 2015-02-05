package es.art83.ticTacToe.models.daos.memory;

import es.art83.ticTacToe.models.daos.PieceDao;
import es.art83.ticTacToe.models.daos.SessionDao;
import es.art83.ticTacToe.models.daos.DaoFactory;

public class DaoMemoryFactory extends DaoFactory {

    private PlayerDaoMemory playerDao = new PlayerDaoMemory();

    private GameDaoMemory gameDao = new GameDaoMemory();
    
    public DaoMemoryFactory() {
    }

    @Override
    public PlayerDaoMemory getPlayerDao() {
        return this.playerDao;
    }

    @Override
    public GameDaoMemory getGameDao() {
        return this.gameDao;
    }

    @Override
    public SessionDao getSessionDao() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PieceDao getPieceDao() {
        // TODO Auto-generated method stub
        return null;
    }

}
