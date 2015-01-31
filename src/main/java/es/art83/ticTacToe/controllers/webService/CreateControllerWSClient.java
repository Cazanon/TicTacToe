package es.art83.ticTacToe.controllers.webService;

import es.art83.ticTacToe.controllers.CreateGameController;
import es.art83.ticTacToe.webService.utils.WS;
import es.art83.ticTacToe.webService.utils.WebServiceClient;

public class CreateControllerWSClient extends ControllerWSClient implements CreateGameController {

    public CreateControllerWSClient(String sessionId) {
        super(sessionId);
    }

    @Override
    public void createGame() {
        WebServiceClient<?> webServiceClient = new WebServiceClient<>(
                WS.PATH_SESSIONS, this.getSessionId(), WS.PATH_GAME);
        webServiceClient.create();
    }

}
