package es.art83.ticTacToe.controllers.ws.client;

import es.art83.ticTacToe.controllers.PlaceCardController;
import es.art83.ticTacToe.controllers.ws.client.utils.TicTacToeResource;
import es.art83.ticTacToe.controllers.ws.client.utils.WebServiceClient;
import es.art83.ticTacToe.models.entities.CoordinateEntity;

public class PlaceControllerWSClient extends ControllerWSClient implements PlaceCardController {

    private String pathSessionsIdGame;

    public PlaceControllerWSClient(String sessionId) {
        super(sessionId);
        this.pathSessionsIdGame = TicTacToeResource.PATH_SESSIONS + "/" + this.getSessionId()
                + TicTacToeResource.PATH_GAME;
    }

    @Override
    public void placeCard(CoordinateEntity coordinateEntity) {
        new WebServiceClient<>(pathSessionsIdGame, TicTacToeResource.PATH_PIECE)
                .create(coordinateEntity);
    }

    @Override
    public void placeCard(CoordinateEntity source, CoordinateEntity destination) {
        WebServiceClient<?> webServiceClient = new WebServiceClient<>(pathSessionsIdGame,
                TicTacToeResource.PATH_PIECE);
        webServiceClient.addMatrixParams("row", String.valueOf(source.getRow()));
        webServiceClient.addMatrixParams("column", String.valueOf(source.getColumn()));
        webServiceClient.delete();
        new WebServiceClient<>(pathSessionsIdGame, TicTacToeResource.PATH_PIECE)
                .create(destination);
    }

}
