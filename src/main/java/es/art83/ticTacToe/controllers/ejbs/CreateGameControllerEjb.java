package es.art83.ticTacToe.controllers.ejbs;

import es.art83.ticTacToe.controllers.CreateGameController;
import es.art83.ticTacToe.models.entities.GameEntity;
import es.art83.ticTacToe.models.entities.SessionEntity;
import es.art83.ticTacToe.models.utils.StateModel;

public class CreateGameControllerEjb extends ControllerEjb implements CreateGameController {

    CreateGameControllerEjb(SessionEntity session) {
        super(session);
    }

    @Override
    protected void changeState() {
        assert this.getSession().getState() == StateModel.CLOSED_GAME
                || this.getSession().getState() == StateModel.OPENED_GAME;
        this.getSession().setState(StateModel.OPENED_GAME);
    }
    
    @Override
    public void createGame() {
       this.getSession().setGame(new GameEntity(this.getSession().getPlayer()));
        this.changeState();
    }


}
