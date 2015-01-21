package es.art83.ticTacToe.models.daos.jpa;

import es.art83.ticTacToe.models.daos.SessionDAO;
import es.art83.ticTacToe.models.entities.SessionEntity;

public class SessionDAOJPA extends TransactionGenericDAOJPA<SessionEntity, Integer> implements
        SessionDAO {

    public SessionDAOJPA() {
        super(SessionEntity.class);
    }


}
