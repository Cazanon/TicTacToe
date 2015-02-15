package es.art83.ticTacToe.controllers.ejbs;

import es.art83.ticTacToe.controllers.SaveGameController;
import es.art83.ticTacToe.models.daos.DaoFactory;
import es.art83.ticTacToe.models.entities.GameEntity;
import es.art83.ticTacToe.models.entities.SessionEntity;
import es.art83.ticTacToe.models.utils.StateModel;

public class SaveGameControllerEjb extends ControllerEjb implements SaveGameController {

    SaveGameControllerEjb(SessionEntity session) {
        super(session);
    }

    @Override
    protected void changeState() {
        assert this.getSession().getState() == StateModel.CLOSED_GAME
                || this.getSession().getState() == StateModel.OPENED_GAME;
    }

    @Override
    public void saveGame() {
        GameEntity game = this.getSession().getGame();
        this.overwriteGame(game.getName());
    }

    @Override
    public void saveGame(String gameName) {
        GameEntity game = this.getSession().getGame();
        game.setName(gameName);
        DaoFactory.getFactory().getGameDao().create(game.clone());
        this.getSession().setSavedGame(true);
        this.changeState();
    }

    @Override
    public void overwriteGame(String gameName) {
        GameEntity game = DaoFactory.getFactory().getGameDao()
                .findPlayerGame(this.getSession().getPlayer(), gameName);
        DaoFactory.getFactory().getGameDao().deleteById(game.getId());
        this.saveGame(gameName);
        this.changeState();
    }

}
