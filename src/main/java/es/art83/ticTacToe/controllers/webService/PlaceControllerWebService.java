package es.art83.ticTacToe.controllers.webService;

import es.art83.ticTacToe.controllers.PlaceCardController;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.webService.utils.WS;
import es.art83.ticTacToe.webService.utils.WebServicesManager;

public class PlaceControllerWebService extends ControllerWebService implements PlaceCardController {

    private String pathSessionsIdGame;

    public PlaceControllerWebService(String sessionId) {
        super(sessionId);
        this.pathSessionsIdGame = WS.PATH_SESSIONS + "/" + this.getSessionId()
                + WS.PATH_GAME;
    }

    @Override
    public void placePiece(CoordinateEntity coordinateEntity) {
        new WebServicesManager<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(coordinateEntity);
    }

    @Override
    public void placePiece(CoordinateEntity source, CoordinateEntity destination) {
        WebServicesManager<?> webServiceClient = new WebServicesManager<>(pathSessionsIdGame,
                WS.PATH_PIECE);
        webServiceClient.addMatrixParams("row", String.valueOf(source.getRow()));
        webServiceClient.addMatrixParams("column", String.valueOf(source.getColumn()));
        webServiceClient.delete();
        new WebServicesManager<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(destination);
    }

}
