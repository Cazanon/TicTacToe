package es.art83.ticTacToe.controllers.webService;

import es.art83.ticTacToe.controllers.LogoutController;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;
import es.art83.ticTacToe.webService.utils.WS;
import es.art83.ticTacToe.webService.utils.WebServicesManager;

public class LogoutControllerWebService extends ControllerWebService implements LogoutController {
    private final String pathSessionsId;

    public LogoutControllerWebService(String sessionId) {
        super(sessionId);
        this.pathSessionsId = WS.PATH_SESSIONS + "/" + this.getSessionId();
    }

    @Override
    public void logout() {
        new WebServicesManager<>(pathSessionsId, WS.PATH_PLAYER).delete();
    }

    @Override
    public boolean isBye() {
        return new WebServicesManager<TicTacToeStateModel>(pathSessionsId,
                WS.PATH_STATE).entity(TicTacToeStateModel.class).equals(
                TicTacToeStateModel.FINAL);
    }

    @Override
    public boolean isSavedGame() {
        return new WebServicesManager<Boolean>(pathSessionsId, WS.PATH_SAVED_GAME)
                .entityBoolean();
    }

}
