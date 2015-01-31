package es.art83.ticTacToe.controllers.webService;

import es.art83.ticTacToe.controllers.LogoutController;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;
import es.art83.ticTacToe.webService.utils.WS;
import es.art83.ticTacToe.webService.utils.WebServiceHandler;

public class LogoutControllerWSClient extends ControllerWSClient implements LogoutController {
    private final String pathSessionsId;

    public LogoutControllerWSClient(String sessionId) {
        super(sessionId);
        this.pathSessionsId = WS.PATH_SESSIONS + "/" + this.getSessionId();
    }

    @Override
    public void logout() {
        new WebServiceHandler<>(pathSessionsId, WS.PATH_PLAYER).delete();
    }

    @Override
    public boolean isBye() {
        return new WebServiceHandler<TicTacToeStateModel>(pathSessionsId,
                WS.PATH_STATE).entity(TicTacToeStateModel.class).equals(
                TicTacToeStateModel.FINAL);
    }

    @Override
    public boolean isSavedGame() {
        return new WebServiceHandler<Boolean>(pathSessionsId, WS.PATH_SAVED_GAME)
                .entityBoolean();
    }

}
