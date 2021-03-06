package es.art83.ticTacToe.controllers.ejbs;

import es.art83.ticTacToe.controllers.LoginController;
import es.art83.ticTacToe.models.daos.DAOFactory;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

public class LoginControllerEJB extends ControllerEJB implements LoginController {

    public LoginControllerEJB(TicTacToeContext ticTacToeStatesManager) {
        super(ticTacToeStatesManager);
    }

    private void changeSate(PlayerEntity player) {
        assert this.getTicTacToeContext().getTicTacToeStateModel() == TicTacToeStateModel.INITIAL
                || this.getTicTacToeContext().getTicTacToeStateModel() == TicTacToeStateModel.FINAL;
        this.getTicTacToeContext().setPlayer(player);
        this.getTicTacToeContext().setTicTacToeStateModel(TicTacToeStateModel.CLOSED_GAME);
    }

    @Override
    public boolean login(PlayerEntity playerEntity) {
        boolean result = false;
        PlayerEntity playerEntityBD = DAOFactory.getFactory().getPlayerDAO().read(playerEntity.getUser());
        if (playerEntityBD != null && playerEntityBD.getPassword().equals(playerEntity.getPassword())) {
            this.changeSate(playerEntityBD);
            result = true;
        }
        return result;
    }

    @Override
    public boolean register(PlayerEntity player) {
        boolean result = false;
        PlayerEntity playerBD = DAOFactory.getFactory().getPlayerDAO().read(player.getUser());
        if (playerBD == null) {
            DAOFactory.getFactory().getPlayerDAO().create(player);
            this.changeSate(player);
            result = true;
        }
        return result;
    }

    @Override
    public boolean logged() {
       return this.getTicTacToeContext().getTicTacToeStateModel() == TicTacToeStateModel.CLOSED_GAME
                || this.getTicTacToeContext().getTicTacToeStateModel() == TicTacToeStateModel.OPENED_GAME;
    }

}
