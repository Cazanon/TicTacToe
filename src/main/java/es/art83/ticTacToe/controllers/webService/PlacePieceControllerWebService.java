package es.art83.ticTacToe.controllers.webService;

import es.art83.ticTacToe.controllers.PlacePieceController;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.webService.utils.WS;
import es.art83.ticTacToe.webService.utils.WebServicesManager;

public class PlacePieceControllerWebService extends ControllerWebService implements PlacePieceController {

    private String pathSessionsIdGame;

    public PlacePieceControllerWebService(String sessionId) {
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
        WebServicesManager<?> webServicesManager = new WebServicesManager<>(pathSessionsIdGame,
                WS.PATH_PIECE);
        webServicesManager.addMatrixParams("row", String.valueOf(source.getRow()));
        webServicesManager.addMatrixParams("column", String.valueOf(source.getColumn()));
        webServicesManager.delete();
        new WebServicesManager<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(destination);
    }

}
