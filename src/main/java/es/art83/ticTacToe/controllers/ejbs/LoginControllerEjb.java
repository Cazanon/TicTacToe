package es.art83.ticTacToe.controllers.ejbs;

import es.art83.ticTacToe.controllers.LoginController;
import es.art83.ticTacToe.models.daos.DaoFactory;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.models.utils.StateModel;

public class LoginControllerEjb extends ControllerEjb implements LoginController {

    LoginControllerEjb(Session session) {
        super(session);
    }

    @Override
    protected void changeState() {
        assert this.getSession().getState() == StateModel.INITIAL
                || this.getSession().getState() == StateModel.FINAL;
        this.getSession().setState(StateModel.CLOSED_GAME);
    }

    @Override
    public boolean login(PlayerEntity player) {
        boolean result = false;
        PlayerEntity playerBD = DaoFactory.getFactory().getPlayerDao().read(player.getUser());
        if (playerBD != null && playerBD.getPassword().equals(player.getPassword())) {
            this.getSession().setPlayer(playerBD);
            this.changeState();
            result = true;
        }
        return result;
    }

    @Override
    public boolean register(PlayerEntity player) {
        boolean result = false;
        PlayerEntity playerBD = DaoFactory.getFactory().getPlayerDao().read(player.getUser());
        if (playerBD == null) {
            DaoFactory.getFactory().getPlayerDao().create(player);
            this.getSession().setPlayer(player);
            this.changeState();
            result = true;
        }
        return result;
    }

    @Override
    public boolean loggedIn() {
        return this.getSession().getState() == StateModel.CLOSED_GAME
                || this.getSession().getState() == StateModel.OPENED_GAME;
    }
}
