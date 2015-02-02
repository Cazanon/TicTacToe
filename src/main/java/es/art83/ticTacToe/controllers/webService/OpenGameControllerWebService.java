package es.art83.ticTacToe.controllers.webService;

import es.art83.ticTacToe.controllers.OpenGameController;
import es.art83.ticTacToe.webService.SessionGameResource;
import es.art83.ticTacToe.webService.SessionResource;
import es.art83.ticTacToe.webService.utils.WebServicesManager;

public class OpenGameControllerWebService extends ControllerWebService implements OpenGameController {

    public OpenGameControllerWebService(String sessionId) {
        super(sessionId);
    }

    @Override
    public void openGame(String gameNameSelected) {
        WebServicesManager<?> webServicesManager = new WebServicesManager<>(
                SessionResource.PATH_SESSIONS, this.getSessionId(), SessionGameResource.PATH_GAME);
        webServicesManager.addParams("name", gameNameSelected);
        webServicesManager.create();
    }

}
