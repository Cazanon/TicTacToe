package es.art83.ticTacToe.controllers.webService;

import es.art83.ticTacToe.controllers.LogoutController;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;
import es.art83.ticTacToe.webService.utils.WS;
import es.art83.ticTacToe.webService.utils.WebServiceClient;

public class LogoutControllerWSClient extends ControllerWSClient implements LogoutController {
    private final String pathSessionsId;

    public LogoutControllerWSClient(String sessionId) {
        super(sessionId);
        this.pathSessionsId = WS.PATH_SESSIONS + "/" + this.getSessionId();
    }

    @Override
    public void logout() {
        new WebServiceClient<>(pathSessionsId, WS.PATH_PLAYER).delete();
    }

    @Override
    public boolean isBye() {
        return new WebServiceClient<TicTacToeStateModel>(pathSessionsId,
                WS.PATH_STATE).entity(TicTacToeStateModel.class).equals(
                TicTacToeStateModel.FINAL);
    }

    @Override
    public boolean isSavedGame() {
        return new WebServiceClient<Boolean>(pathSessionsId, WS.PATH_SAVED_GAME)
                .entityBoolean();
    }

}
