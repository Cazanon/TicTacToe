package es.art83.ticTacToe.controllers.ejbs;

abstract class ControllerEjb {

    private Session ticTacToeSession;

    protected ControllerEjb(Session ticTacToeSession) {
        this.ticTacToeSession = ticTacToeSession;
    }

    protected Session getSession() {
        return ticTacToeSession;
    }
    
    abstract protected void changeState();

}
