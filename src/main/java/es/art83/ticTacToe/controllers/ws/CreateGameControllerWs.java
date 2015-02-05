package es.art83.ticTacToe.controllers.ws;

import es.art83.ticTacToe.controllers.CreateGameController;
import es.art83.ticTacToe.webService.SessionGameResource;
import es.art83.ticTacToe.webService.SessionResource;
import es.art83.ticTacToe.webService.utils.WebServicesManager;

public class CreateGameControllerWs extends ControllerWebService implements CreateGameController {

    public CreateGameControllerWs(String sessionId) {
        super(sessionId);
    }

    @Override
    public void createGame() {
        WebServicesManager<?> webServicesManager = new WebServicesManager<>(
                SessionResource.PATH_SESSIONS, this.getSessionId(), SessionGameResource.PATH_GAME);
        webServicesManager.create();
    }

}
