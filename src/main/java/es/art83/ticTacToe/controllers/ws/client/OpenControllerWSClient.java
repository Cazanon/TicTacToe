package es.art83.ticTacToe.controllers.ws.client;

import es.art83.ticTacToe.controllers.OpenGameController;
import es.art83.ticTacToe.controllers.ws.client.utils.TicTacToeResource;
import es.art83.ticTacToe.controllers.ws.client.utils.WebServiceClient;

public class OpenControllerWSClient extends ControllerWSClient implements OpenGameController {

    public OpenControllerWSClient(String sessionId) {
        super(sessionId);
    }

    @Override
    public void openGame(String gameNameSelected) {
        WebServiceClient<?> webServiceClient = new WebServiceClient<>(
                TicTacToeResource.PATH_SESSIONS, this.getSessionId(), TicTacToeResource.PATH_GAME);
        webServiceClient.addParams("name", gameNameSelected);
        webServiceClient.create();
    }

}
