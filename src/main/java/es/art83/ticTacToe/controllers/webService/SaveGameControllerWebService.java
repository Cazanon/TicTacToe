package es.art83.ticTacToe.controllers.webService;

import es.art83.ticTacToe.controllers.SaveGameController;
import es.art83.ticTacToe.webService.utils.WS;
import es.art83.ticTacToe.webService.utils.WebServicesManager;

public class SaveGameControllerWebService extends ControllerWebService implements SaveGameController {

    public SaveGameControllerWebService(String sessionId) {
        super(sessionId);
    }

    @Override
    public void saveGame(String gameName) {
        new WebServicesManager<>(WS.PATH_SESSIONS, this.getSessionId(),
                WS.PATH_GAME, WS.PATH_NAME).create(gameName);
        WebServicesManager<?> webServicesManager = new WebServicesManager<>(WS.PATH_GAMES);
        webServicesManager.addParams("sessionId", this.getSessionId());
        webServicesManager.create();
    }

    @Override
    public void overWriteGame(String gameName) {
        // Se busca y se borra
        WebServicesManager<String> webServicesManager = new WebServicesManager<String>(
                WS.PATH_GAMES, WS.PATH_SEARCH);
        webServicesManager.addParams("sessionId", this.getSessionId());
        webServicesManager.addParams("name", gameName);
        String gameId = webServicesManager.entity(String.class);
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
