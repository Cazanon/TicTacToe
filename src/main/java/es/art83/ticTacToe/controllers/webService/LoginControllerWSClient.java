package es.art83.ticTacToe.controllers.webService;

import es.art83.ticTacToe.controllers.LoginController;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.webService.utils.WS;
import es.art83.ticTacToe.webService.utils.WebServiceClient;

public class LoginControllerWSClient extends ControllerWSClient implements LoginController {
    private final String pathSessionsId;

    public LoginControllerWSClient(String sessionId) {
        super(sessionId);
        this.pathSessionsId = WS.PATH_SESSIONS + "/" + this.getSessionId();
    }

    @Override
    public boolean login(PlayerEntity playerEntity) {
        return new WebServiceClient<>(pathSessionsId, WS.PATH_PLAYER)
                .create(playerEntity);
    }

    @Override
    public boolean register(PlayerEntity playerEntity) {
        boolean result = false;
        WebServiceClient<?> webServiceClient = new WebServiceClient<>(
                WS.PATH_PLAYERS);
        if (webServiceClient.create(playerEntity)) {
            result = this.login(playerEntity);
        }
        return result;
    }

    @Override
    public boolean logged() {
       return new WebServiceClient<Boolean>(
               pathSessionsId, WS.PATH_LOGGED).entityBoolean();
    }

}
