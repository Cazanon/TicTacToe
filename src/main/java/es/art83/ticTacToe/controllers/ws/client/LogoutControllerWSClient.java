package es.art83.ticTacToe.controllers.ws.client;

import es.art83.ticTacToe.controllers.LogoutController;
import es.art83.ticTacToe.controllers.ws.client.utils.TicTacToeResource;
import es.art83.ticTacToe.controllers.ws.client.utils.WebServiceClient;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

public class LogoutControllerWSClient extends ControllerWSClient implements LogoutController {

    public LogoutControllerWSClient(String sessionId) {
        super(sessionId);
    }

    @Override
    public void logout() {
        WebServiceClient<?> webServiceClient = new WebServiceClient<>(
                TicTacToeResource.PATH_SESSIONS, this.getSessionId(), TicTacToeResource.PATH_PLAYER);
        webServiceClient.delete();
    }

    @Override
    public boolean isBye() {
        WebServiceClient<TicTacToeStateModel> webServiceClient = new WebServiceClient<>(
                TicTacToeResource.PATH_SESSIONS, this.getSessionId(), TicTacToeResource.PATH_STATE);
        webServiceClient.read();
        TicTacToeStateModel state = webServiceClient.entity(TicTacToeStateModel.class);
        return state.equals(TicTacToeStateModel.FINAL);
    }

    @Override
    public boolean isSavedGame() {
        WebServiceClient<Boolean> webServiceClient = new WebServiceClient<>(
                TicTacToeResource.PATH_SESSIONS, this.getSessionId(),
                TicTacToeResource.PATH_SAVED_GAME);
        webServiceClient.read();
        return webServiceClient.entityBoolean();
    }

}
