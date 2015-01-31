package es.art83.ticTacToe.controllers.webService;

import es.art83.ticTacToe.controllers.CreateGameController;
import es.art83.ticTacToe.controllers.webService.utils.TicTacToeResource;
import es.art83.ticTacToe.controllers.webService.utils.WebServiceClient;

public class CreateControllerWSClient extends ControllerWSClient implements CreateGameController {

    public CreateControllerWSClient(String sessionId) {
        super(sessionId);
    }

    @Override
    public void createGame() {
        WebServiceClient<?> webServiceClient = new WebServiceClient<>(
                TicTacToeResource.PATH_SESSIONS, this.getSessionId(), TicTacToeResource.PATH_GAME);
        webServiceClient.create();
    }

}
