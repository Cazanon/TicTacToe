package es.art83.ticTacToe.controllers.ejbs;

import es.art83.ticTacToe.models.entities.SessionEntity;

abstract class ControllerEjb {

    private SessionEntity ticTacToeSession;

    protected ControllerEjb(SessionEntity ticTacToeSession) {
        this.ticTacToeSession = ticTacToeSession;
    }

    protected SessionEntity getSession() {
        return ticTacToeSession;
    }
    
    abstract protected void changeState();

}
