package es.art83.ticTacToe.controllers.ejbs;

import es.art83.ticTacToe.controllers.CreateGameController;
import es.art83.ticTacToe.models.entities.GameEntity;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

public class CreateGameControllerEJB extends ControllerEJB implements CreateGameController {

    public CreateGameControllerEJB(TicTacToeSession ticTacToeSession) {
        super(ticTacToeSession);
    }

    @Override
    public void createGame() {
        assert this.getTicTacToeSession().getTicTacToeStateModel() == TicTacToeStateModel.CLOSED_GAME;
        this.getTicTacToeSession().setGame(new GameEntity(this.getTicTacToeSession().getPlayer()));
        this.getTicTacToeSession().setTicTacToeStateModel(TicTacToeStateModel.OPENED_GAME);
    }

}
