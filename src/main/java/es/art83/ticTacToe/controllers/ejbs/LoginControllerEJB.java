package es.art83.ticTacToe.controllers.ejbs;

import es.art83.ticTacToe.controllers.LoginController;
import es.art83.ticTacToe.models.daos.DAOFactory;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

public class LoginControllerEJB extends ControllerEJB implements LoginController {

    public LoginControllerEJB(TicTacToeSession ticTacToeSession) {
        super(ticTacToeSession);
    }

    private void changeSate(PlayerEntity player) {
        assert this.getTicTacToeSession().getTicTacToeStateModel() == TicTacToeStateModel.INITIAL
                || this.getTicTacToeSession().getTicTacToeStateModel() == TicTacToeStateModel.FINAL;
        this.getTicTacToeSession().setPlayer(player);
        this.getTicTacToeSession().setTicTacToeStateModel(TicTacToeStateModel.CLOSED_GAME);
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
       return this.getTicTacToeSession().getTicTacToeStateModel() == TicTacToeStateModel.CLOSED_GAME
                || this.getTicTacToeSession().getTicTacToeStateModel() == TicTacToeStateModel.OPENED_GAME;
    }

}
