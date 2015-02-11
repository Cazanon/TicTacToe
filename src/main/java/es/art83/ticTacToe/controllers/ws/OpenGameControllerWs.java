package es.art83.ticTacToe.controllers.ws;

import es.art83.ticTacToe.controllers.OpenGameController;
import es.art83.ticTacToe.ws.SessionGameUris;
import es.art83.ticTacToe.ws.SessionUris;

public class OpenGameControllerWs extends ControllerWs implements OpenGameController {

    public OpenGameControllerWs(String sessionId) {
        super(sessionId);
    }

    @Override
    public void openGame(String gameName) {
        WsManager webServicesManager = ControllerWs.buildWebServiceManager(
                SessionUris.PATH_SESSIONS, this.getSessionId(), SessionGameUris.PATH_GAME);
        webServicesManager.addParams("name", gameName);
        webServicesManager.create();
    }

}
