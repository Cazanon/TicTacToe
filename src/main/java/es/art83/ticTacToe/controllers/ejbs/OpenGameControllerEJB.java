package es.art83.ticTacToe.controllers.ejbs;

import es.art83.ticTacToe.controllers.OpenGameController;
import es.art83.ticTacToe.models.daos.DAOFactory;
import es.art83.ticTacToe.models.entities.GameEntity;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

public class OpenGameControllerEJB extends ControllerEJB implements OpenGameController {

    public OpenGameControllerEJB(TicTacToeSession ticTacToeStatesManager) {
        super(ticTacToeStatesManager);
    }

    private void changeSate() {
        this.getTicTacToeSession().setTicTacToeStateModel(TicTacToeStateModel.OPENED_GAME);
    }
 
    
    @Override
    public void openGame(String gameNameSelected) {
        GameEntity game = DAOFactory.getFactory().getGameDAO()
                .findPlayerGame(this.getTicTacToeSession().getPlayer(), gameNameSelected);
        this.getTicTacToeSession().setGame(game);
        this.getTicTacToeSession().setSaved(true);
        this.changeSate();
    }

}
