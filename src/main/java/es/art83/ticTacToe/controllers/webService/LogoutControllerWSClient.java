package es.art83.ticTacToe.controllers.webService;

import es.art83.ticTacToe.controllers.LogoutController;
import es.art83.ticTacToe.controllers.webService.utils.TicTacToeResource;
import es.art83.ticTacToe.controllers.webService.utils.WebServiceClient;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

public class LogoutControllerWSClient extends ControllerWSClient implements LogoutController {
    private final String pathSessionsId;

    public LogoutControllerWSClient(String sessionId) {
        super(sessionId);
        this.pathSessionsId = TicTacToeResource.PATH_SESSIONS + "/" + this.getSessionId();
    }

    @Override
    public void logout() {
        new WebServiceClient<>(pathSessionsId, TicTacToeResource.PATH_PLAYER).delete();
    }

    @Override
    public boolean isBye() {
        return new WebServiceClient<TicTacToeStateModel>(pathSessionsId,
                TicTacToeResource.PATH_STATE).entity(TicTacToeStateModel.class).equals(
                TicTacToeStateModel.FINAL);
    }

    @Override
    public boolean isSavedGame() {
        return new WebServiceClient<Boolean>(pathSessionsId, TicTacToeResource.PATH_SAVED_GAME)
                .entityBoolean();
    }

}
