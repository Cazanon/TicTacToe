package es.art83.ticTacToe.controllers.webService;

import es.art83.ticTacToe.controllers.OpenGameController;
import es.art83.ticTacToe.webService.utils.WS;
import es.art83.ticTacToe.webService.utils.WebServiceClient;

public class OpenControllerWSClient extends ControllerWSClient implements OpenGameController {

    public OpenControllerWSClient(String sessionId) {
        super(sessionId);
    }

    @Override
    public void openGame(String gameNameSelected) {
        WebServiceClient<?> webServiceClient = new WebServiceClient<>(
                WS.PATH_SESSIONS, this.getSessionId(), WS.PATH_GAME);
        webServiceClient.addParams("name", gameNameSelected);
        webServiceClient.create();
    }

}
