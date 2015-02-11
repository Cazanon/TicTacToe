package es.art83.ticTacToe.controllers.ws;

import es.art83.ticTacToe.controllers.SaveGameController;
import es.art83.ticTacToe.ws.GameUris;
import es.art83.ticTacToe.ws.SessionGameUris;
import es.art83.ticTacToe.ws.SessionUris;

public class SaveGameControllerWs extends ControllerWs implements SaveGameController {

    public SaveGameControllerWs(String sessionId) {
        super(sessionId);
    }

    @Override
    public void saveGame(String gameName) {
        ControllerWs.buildWebServiceManager(SessionUris.PATH_SESSIONS, this.getSessionId(),
                SessionGameUris.PATH_GAME, SessionGameUris.PATH_NAME).create(gameName);
        WsManager webServicesManager = ControllerWs.buildWebServiceManager(GameUris.PATH_GAMES);
        webServicesManager.addParams("sessionId", this.getSessionId());
        webServicesManager.create();
    }

    @Override
    public void saveGame() {
        String gameName = ControllerWs.buildWebServiceManager(SessionUris.PATH_SESSIONS,
                this.getSessionId(), SessionGameUris.PATH_GAME, SessionGameUris.PATH_NAME)
                .entity(String.class);
        this.overwriteGame(gameName);
    }
    
    @Override
    public void overwriteGame(String gameName) {
        // Se busca el juego y se borra
        WsManager webServicesManager = ControllerWs.buildWebServiceManager(
                GameUris.PATH_GAMES, GameUris.PATH_SEARCH);
        webServicesManager.addParams("sessionId", this.getSessionId());
        webServicesManager.addParams("name", gameName);
        String gameId = webServicesManager.entity(String.class);
        ControllerWs.buildWebServiceManager(GameUris.PATH_GAMES, gameId).delete();
        this.saveGame(gameName);
    }


}
