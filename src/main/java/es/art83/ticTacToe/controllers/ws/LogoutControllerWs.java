package es.art83.ticTacToe.controllers.ws;

import es.art83.ticTacToe.controllers.LogoutController;
import es.art83.ticTacToe.models.utils.StateModel;
import es.art83.ticTacToe.webService.SessionPlayerResource;
import es.art83.ticTacToe.webService.SessionResource;

public class LogoutControllerWs extends ControllerWebService implements LogoutController {
    private final String pathSessionsId;

    public LogoutControllerWs(String sessionId) {
        super(sessionId);
        this.pathSessionsId = SessionResource.PATH_SESSIONS + "/" + this.getSessionId();
    }

    @Override
    public void logout() {
        ControllerWebService.buildWebServiceManager(pathSessionsId, SessionPlayerResource.PATH_PLAYER).delete();
    }

    @Override
    public boolean loggedOut() {
        return ControllerWebService.buildWebServiceManager(pathSessionsId, SessionResource.PATH_STATE)
                .entity(StateModel.class).equals(StateModel.FINAL);
    }

    @Override
    public boolean savedGame() {
        return ControllerWebService.buildWebServiceManager(pathSessionsId, SessionResource.PATH_SAVED_GAME)
                .entityBoolean();
    }

}
