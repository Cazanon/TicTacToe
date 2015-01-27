package es.art83.ticTacToe.controllers.ws.client;

import es.art83.ticTacToe.controllers.LoginController;
import es.art83.ticTacToe.controllers.ws.client.utils.TicTacToeResource;
import es.art83.ticTacToe.controllers.ws.client.utils.WebServiceClient;
import es.art83.ticTacToe.models.entities.PlayerEntity;

public class LoginControllerWSClient extends ControllerWSClient implements LoginController {

    public LoginControllerWSClient(String sessionId) {
        super(sessionId);
    }

    @Override
    public boolean login(PlayerEntity playerEntity) {
        WebServiceClient<?> webServiceClient = new WebServiceClient<>(
                TicTacToeResource.PATH_SESSIONS, this.getSessionId(), TicTacToeResource.PATH_PLAYER);
        return webServiceClient.create(playerEntity);
    }

    @Override
    public boolean register(PlayerEntity playerEntity) {
        boolean result = false;
        WebServiceClient<?> webServiceClient = new WebServiceClient<>(
                TicTacToeResource.PATH_PLAYERS);
        if (webServiceClient.create(playerEntity)) {
            result = this.login(playerEntity);
        }
        return result;
    }

    @Override
    public boolean logged() {
        WebServiceClient<Boolean> webServiceClient = new WebServiceClient<>(
                TicTacToeResource.PATH_SESSIONS, this.getSessionId(), TicTacToeResource.PATH_LOGGED);
        webServiceClient.read();
        return webServiceClient.entity(Boolean.class);
    }

}
