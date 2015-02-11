package es.art83.ticTacToe.controllers.ws;

import es.art83.ticTacToe.controllers.SaveGameController;
import es.art83.ticTacToe.ws.GameResource;
import es.art83.ticTacToe.ws.SessionGameResource;
import es.art83.ticTacToe.ws.SessionResource;

public class SaveGameControllerWs extends ControllerWs implements SaveGameController {

    public SaveGameControllerWs(String sessionId) {
        super(sessionId);
    }

    @Override
    public void saveGame(String gameName) {
        ControllerWs.buildWebServiceManager(SessionResource.PATH_SESSIONS, this.getSessionId(),
                SessionGameResource.PATH_GAME, SessionGameResource.PATH_NAME).create(gameName);
        WsManager webServicesManager = ControllerWs.buildWebServiceManager(GameResource.PATH_GAMES);
        webServicesManager.addParams("sessionId", this.getSessionId());
        webServicesManager.create();
    }

    @Override
    public void saveGame() {
        String gameName = ControllerWs.buildWebServiceManager(SessionResource.PATH_SESSIONS,
                this.getSessionId(), SessionGameResource.PATH_GAME, SessionGameResource.PATH_NAME)
                .entity(String.class);
        this.overwriteGame(gameName);
    }
    
    @Override
    public void overwriteGame(String gameName) {
        // Se busca el juego y se borra
        WsManager webServicesManager = ControllerWs.buildWebServiceManager(
                GameResource.PATH_GAMES, GameResource.PATH_SEARCH);
        webServicesManager.addParams("sessionId", this.getSessionId());
        webServicesManager.addParams("name", gameName);
        String gameId = webServicesManager.entity(String.class);
        ControllerWs.buildWebServiceManager(GameResource.PATH_GAMES, gameId).delete();
        this.saveGame(gameName);
    }


}
