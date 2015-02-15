package es.art83.ticTacToe.controllers.ws;

import es.art83.ticTacToe.controllers.LogoutController;
import es.art83.ticTacToe.ws.SessionPlayerUris;
import es.art83.ticTacToe.ws.SessionUris;

public class LogoutControllerWs extends ControllerWs implements LogoutController {
    private final String pathSessionsId;

    LogoutControllerWs(String sessionId) {
        super(sessionId);
        this.pathSessionsId = SessionUris.PATH_SESSIONS + "/" + this.getSessionId();
    }

    @Override
    public void logout() {
        ControllerWs.buildWebServiceManager(pathSessionsId, SessionPlayerUris.PATH_PLAYER).delete();
    }

    @Override
    public boolean savedGame() {
        return ControllerWs.buildWebServiceManager(pathSessionsId, SessionUris.PATH_SAVED_GAME)
                .entityBoolean();
    }

}
