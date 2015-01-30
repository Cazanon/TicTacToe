package es.art83.ticTacToe.controllers.ws.client;

import es.art83.ticTacToe.controllers.SaveGameController;
import es.art83.ticTacToe.controllers.ws.client.utils.TicTacToeResource;
import es.art83.ticTacToe.controllers.ws.client.utils.WebServiceClient;

public class SaveControllerWSClient extends ControllerWSClient implements SaveGameController {

    public SaveControllerWSClient(String sessionId) {
        super(sessionId);
    }

    @Override
    public void saveGame(String gameName) {
        new WebServiceClient<>(TicTacToeResource.PATH_SESSIONS, this.getSessionId(),
                TicTacToeResource.PATH_GAME, TicTacToeResource.PATH_NAME).create(gameName);
        WebServiceClient<?> webServiceClient = new WebServiceClient<>(TicTacToeResource.PATH_GAMES);
        webServiceClient.addParams("sessionId", this.getSessionId());
        webServiceClient.create();
    }

    @Override
    public void overWriteGame(String gameName) {
        // TODO Auto-generated method stub

    }

    @Override
    public void saveGame() {
        // TODO Auto-generated method stub

    }

}
