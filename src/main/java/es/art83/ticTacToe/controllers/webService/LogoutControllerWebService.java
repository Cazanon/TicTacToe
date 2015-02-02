package es.art83.ticTacToe.controllers.webService;

import es.art83.ticTacToe.controllers.LogoutController;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;
import es.art83.ticTacToe.webService.SessionPlayerResource;
import es.art83.ticTacToe.webService.SessionResource;
import es.art83.ticTacToe.webService.utils.WebServicesManager;

public class LogoutControllerWebService extends ControllerWebService implements LogoutController {
    private final String pathSessionsId;

    public LogoutControllerWebService(String sessionId) {
        super(sessionId);
        this.pathSessionsId = SessionResource.PATH_SESSIONS + "/" + this.getSessionId();
    }

    @Override
    public void logout() {
        new WebServicesManager<>(pathSessionsId, SessionPlayerResource.PATH_PLAYER).delete();
    }

    @Override
    public boolean logouted() {
        return new WebServicesManager<TicTacToeStateModel>(pathSessionsId,
                SessionResource.PATH_STATE).entity(TicTacToeStateModel.class).equals(
                TicTacToeStateModel.FINAL);
    }

    @Override
    public boolean savedGame() {
        return new WebServicesManager<Boolean>(pathSessionsId, SessionResource.PATH_SAVED_GAME)
                .entityBoolean();
    }

}
