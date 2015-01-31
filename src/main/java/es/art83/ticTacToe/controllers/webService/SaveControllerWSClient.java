package es.art83.ticTacToe.controllers.webService;

import es.art83.ticTacToe.controllers.SaveGameController;
import es.art83.ticTacToe.webService.utils.TicTacToeResource;
import es.art83.ticTacToe.webService.utils.WebServiceClient;

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
        // Se busca y se borra
        WebServiceClient<String> webServiceClient = new WebServiceClient<String>(
                TicTacToeResource.PATH_GAMES, TicTacToeResource.PATH_SEARCH);
        webServiceClient.addParams("sessionId", this.getSessionId());
        webServiceClient.addParams("name", gameName);
        String gameId = webServiceClient.entity(String.class);
        new WebServiceClient<>(TicTacToeResource.PATH_GAMES, gameId).delete();

        this.saveGame(gameName);
    }

    @Override
    public void saveGame() {
        String gameName = new WebServiceClient<String>(TicTacToeResource.PATH_SESSIONS,
                this.getSessionId(), TicTacToeResource.PATH_GAME, TicTacToeResource.PATH_NAME)
                .entity(String.class);
        this.overWriteGame(gameName);
    }

}
