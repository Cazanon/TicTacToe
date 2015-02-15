package es.art83.ticTacToe.models.daos;

import es.art83.ticTacToe.models.daos.jpa.DaoJpaFactory;

public abstract class DaoFactory {
    public static DaoFactory factory = null;

    public static void setFactory(DaoFactory factory) {
        DaoFactory.factory = factory;
    }

    //TODO romper esta referencia a DaoJpaFactory pq crea una dependencia bidireccional
    public static DaoFactory getFactory() {
        if (factory == null) {
            factory = new DaoJpaFactory();
        }
        return factory;
    }

    public abstract PlayerDao getPlayerDao();
    
    public abstract GameDao getGameDao();
    
    public abstract SessionDao getSessionDao();
    
    public abstract PieceDao getPieceDao();
    
}
