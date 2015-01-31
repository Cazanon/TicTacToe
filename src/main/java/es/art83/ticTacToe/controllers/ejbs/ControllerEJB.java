package es.art83.ticTacToe.controllers.ejbs;

public class ControllerEJB {

    private TicTacToeSession ticTacToeSession;

    public ControllerEJB(TicTacToeSession ticTacToeSession) {
        this.ticTacToeSession = ticTacToeSession;
    }

    protected TicTacToeSession getTicTacToeSession() {
        return ticTacToeSession;
    }

}
