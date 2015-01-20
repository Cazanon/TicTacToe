package es.art83.ticTacToe.models.daos.jpa;

import es.art83.ticTacToe.models.daos.ContextDAO;
import es.art83.ticTacToe.models.entities.SessionEntity;

public class ContextDAOJPA extends TransactionGenericDAOJPA<SessionEntity, Integer> implements
        ContextDAO {

    public ContextDAOJPA() {
        super(SessionEntity.class);
    }


}
