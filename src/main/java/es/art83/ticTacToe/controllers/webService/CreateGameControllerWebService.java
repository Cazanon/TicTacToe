package es.art83.ticTacToe.controllers.webService;

import es.art83.ticTacToe.controllers.CreateGameController;
import es.art83.ticTacToe.webService.SessionGameResource;
import es.art83.ticTacToe.webService.SessionResource;
import es.art83.ticTacToe.webService.utils.WebServicesManager;

public class CreateGameControllerWebService extends ControllerWebService implements CreateGameController {

    public CreateGameControllerWebService(String sessionId) {
        super(sessionId);
    }

    @Override
    public void createGame() {
        WebServicesManager<?> webServicesManager = new WebServicesManager<>(
                SessionResource.PATH_SESSIONS, this.getSessionId(), SessionGameResource.PATH_GAME);
        webServicesManager.create();
    }

}
