package es.art83.ticTacToe.controllers.webService;

import es.art83.ticTacToe.controllers.LoginController;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.webService.PlayerResource;
import es.art83.ticTacToe.webService.SessionPlayerResource;
import es.art83.ticTacToe.webService.SessionResource;
import es.art83.ticTacToe.webService.utils.WebServicesManager;

public class LoginControllerWebService extends ControllerWebService implements LoginController {
    private final String pathSessionsId;

    public LoginControllerWebService(String sessionId) {
        super(sessionId);
        this.pathSessionsId = SessionResource.PATH_SESSIONS + "/" + this.getSessionId();
    }

    @Override
    public boolean login(PlayerEntity playerEntity) {
        return new WebServicesManager<>(pathSessionsId, SessionPlayerResource.PATH_PLAYER)
                .create(playerEntity);
    }

    @Override
    public boolean register(PlayerEntity playerEntity) {
        boolean result = false;
        WebServicesManager<?> webServicesManager = new WebServicesManager<>(
                PlayerResource.PATH_PLAYERS);
        if (webServicesManager.create(playerEntity)) {
            result = this.login(playerEntity);
        }
        return result;
    }

    @Override
    public boolean logged() {
       return new WebServicesManager<Boolean>(
               pathSessionsId, SessionResource.PATH_LOGGED).entityBoolean();
    }

}
