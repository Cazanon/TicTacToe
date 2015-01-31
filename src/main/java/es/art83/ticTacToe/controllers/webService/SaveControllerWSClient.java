package es.art83.ticTacToe.controllers.webService;

import es.art83.ticTacToe.controllers.SaveGameController;
import es.art83.ticTacToe.webService.utils.WS;
import es.art83.ticTacToe.webService.utils.WebServicesManager;

public class SaveControllerWSClient extends ControllerWSClient implements SaveGameController {

    public SaveControllerWSClient(String sessionId) {
        super(sessionId);
    }

    @Override
    public void saveGame(String gameName) {
        new WebServicesManager<>(WS.PATH_SESSIONS, this.getSessionId(),
                WS.PATH_GAME, WS.PATH_NAME).create(gameName);
        WebServicesManager<?> webServiceClient = new WebServicesManager<>(WS.PATH_GAMES);
        webServiceClient.addParams("sessionId", this.getSessionId());
        webServiceClient.create();
    }

    @Override
    public void overWriteGame(String gameName) {
        // Se busca y se borra
        WebServicesManager<String> webServiceClient = new WebServicesManager<String>(
                WS.PATH_GAMES, WS.PATH_SEARCH);
        webServiceClient.addParams("sessionId", this.getSessionId());
        webServiceClient.addParams("name", gameName);
        String gameId = webServiceClient.entity(String.class);
        new WebServicesManager<>(WS.PATH_GAMES, gameId).delete();

        this.saveGame(gameName);
    }

    @Override
    public void saveGame() {
        String gameName = new WebServicesManager<String>(WS.PATH_SESSIONS,
                this.getSessionId(), WS.PATH_GAME, WS.PATH_NAME)
                .entity(String.class);
        this.overWriteGame(gameName);
    }

}
