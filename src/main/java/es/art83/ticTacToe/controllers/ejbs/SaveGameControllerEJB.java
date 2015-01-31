package es.art83.ticTacToe.controllers.ejbs;

import es.art83.ticTacToe.controllers.SaveGameController;
import es.art83.ticTacToe.models.daos.DAOFactory;
import es.art83.ticTacToe.models.entities.GameEntity;

public class SaveGameControllerEJB extends ControllerEJB implements SaveGameController {

    public SaveGameControllerEJB(TicTacToeSession ticTacToeStatesManager) {
        super(ticTacToeStatesManager);
    }

    @Override
    public void saveGame(String gameName) {
        GameEntity gameEntity = this.getTicTacToeSession().getGame();
        gameEntity.setName(gameName);
        DAOFactory.getFactory().getGameDAO().create(gameEntity);
        this.getTicTacToeSession().setSaved(true);
    }

    @Override
    public void overWriteGame(String gameName) {
        GameEntity game = DAOFactory.getFactory().getGameDAO()
                .findPlayerGame(this.getTicTacToeSession().getPlayer(), gameName);
        DAOFactory.getFactory().getGameDAO().delete(game);
        this.saveGame(gameName);
    }

    @Override
    public void saveGame() {
        GameEntity gameEntity = this.getTicTacToeSession().getGame();
        DAOFactory.getFactory().getGameDAO().update(gameEntity);
        this.getTicTacToeSession().setSaved(true);
    }

}
