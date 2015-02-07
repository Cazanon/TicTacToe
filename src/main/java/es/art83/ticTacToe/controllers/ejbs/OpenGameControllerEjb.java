package es.art83.ticTacToe.controllers.ejbs;

import es.art83.ticTacToe.controllers.OpenGameController;
import es.art83.ticTacToe.models.daos.DaoFactory;
import es.art83.ticTacToe.models.entities.GameEntity;
import es.art83.ticTacToe.models.utils.StateModel;

public class OpenGameControllerEjb extends ControllerEjb implements OpenGameController {

    OpenGameControllerEjb(Session session) {
        super(session);
    }

    @Override
    protected void changeState() {
        assert this.getSession().getState() == StateModel.CLOSED_GAME
                || this.getSession().getState() == StateModel.OPENED_GAME;
        this.getSession().setState(StateModel.OPENED_GAME);
    }

    @Override
    public void openGame(String selectedNameGame) {
        GameEntity game = DaoFactory.getFactory().getGameDao()
                .findPlayerGame(this.getSession().getPlayer(), selectedNameGame);
        game = game.clone();
        this.getSession().setGame(game);
        this.getSession().setSavedGame(true);
        this.changeState();
    }
}
