package es.art83.ticTacToe.controllers.ws;

import es.art83.ticTacToe.controllers.LoginController;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.models.utils.StateModel;
import es.art83.ticTacToe.ws.PlayerUris;
import es.art83.ticTacToe.ws.SessionPlayerUris;
import es.art83.ticTacToe.ws.SessionUris;

public class LoginControllerWs extends ControllerWs implements LoginController {
    private final String pathSessionsId;

    LoginControllerWs(String sessionId) {
        super(sessionId);
        this.pathSessionsId = SessionUris.PATH_SESSIONS + "/" + this.getSessionId();
    }
    

    @Override
    public boolean loggedOut() {
        return ControllerWs.buildWebServiceManager(pathSessionsId, SessionUris.PATH_STATE)
                .entity(StateModel.class).equals(StateModel.FINAL);
    }

    @Override
    public boolean login(PlayerEntity player) {
        return ControllerWs.buildWebServiceManager(pathSessionsId, SessionPlayerUris.PATH_PLAYER)
                .create(player);
    }

    @Override
    public boolean register(PlayerEntity player) {
        boolean result = false;
        WsManager webServicesManager = ControllerWs.buildWebServiceManager(
                PlayerUris.PATH_PLAYERS);
        if (webServicesManager.create(player)) {
            result = this.login(player);
        }
        return result;
    }

    @Override
    public boolean loggedIn() {
       return ControllerWs.buildWebServiceManager(
               pathSessionsId, SessionUris.PATH_LOGGED).entityBoolean();
    }

}
