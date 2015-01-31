package es.art83.ticTacToe.controllers.ejbs;

import es.art83.ticTacToe.controllers.LogoutController;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

public class LogoutControllerEJB extends ControllerEJB implements LogoutController {

    public LogoutControllerEJB(TicTacToeSession ticTacToeStatesManager) {
        super(ticTacToeStatesManager);
    }
    
    private void changeState(){
        this.getTicTacToeSession().setTicTacToeStateModel(TicTacToeStateModel.FINAL);
    }

    @Override
    public void logout() {
        assert this.getTicTacToeSession().getTicTacToeStateModel() == TicTacToeStateModel.CLOSED_GAME
                || this.getTicTacToeSession().getTicTacToeStateModel() == TicTacToeStateModel.OPENED_GAME;
        this.getTicTacToeSession().setPlayer(null);
        this.getTicTacToeSession().setGame(null);
        this.getTicTacToeSession().setSaved(true);
        this.changeState();
    }

    @Override
    public boolean isBye() {
        return this.getTicTacToeSession().getTicTacToeStateModel() == TicTacToeStateModel.FINAL;
    }

    @Override
    public boolean isSavedGame() {
        return this.getTicTacToeSession().isSavedGame();
    }

}
