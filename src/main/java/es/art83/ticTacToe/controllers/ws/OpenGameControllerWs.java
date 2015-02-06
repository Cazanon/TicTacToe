package es.art83.ticTacToe.controllers.ws;

import es.art83.ticTacToe.controllers.OpenGameController;
import es.art83.ticTacToe.webService.SessionGameResource;
import es.art83.ticTacToe.webService.SessionResource;

public class OpenGameControllerWs extends ControllerWebService implements OpenGameController {

    public OpenGameControllerWs(String sessionId) {
        super(sessionId);
    }

    @Override
    public void openGame(String gameName) {
        WebServicesManager webServicesManager = ControllerWebService.buildWebServiceManager(
                SessionResource.PATH_SESSIONS, this.getSessionId(), SessionGameResource.PATH_GAME);
        webServicesManager.addParams("name", gameName);
        webServicesManager.create();
    }

}
