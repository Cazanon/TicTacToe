package es.art83.ticTacToe.controllers.ws;

import es.art83.ticTacToe.controllers.CreateGameController;
import es.art83.ticTacToe.ws.SessionGameResource;
import es.art83.ticTacToe.ws.SessionResource;

public class CreateGameControllerWs extends ControllerWs implements CreateGameController {

    public CreateGameControllerWs(String sessionId) {
        super(sessionId);
    }

    @Override
    public void createGame() {
        // Se busca si existe una partida a medias
        WsManager webServicesManager = ControllerWs.buildWebServiceManager(
                SessionResource.PATH_SESSIONS, this.getSessionId(), SessionGameResource.PATH_GAME);
        webServicesManager.create();
    }

}
