package es.art83.ticTacToe.controllers.ws;

import es.art83.ticTacToe.controllers.PlacePieceController;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.ws.SessionGameUris;
import es.art83.ticTacToe.ws.SessionUris;

public class PlacePieceControllerWs extends ControllerWs implements PlacePieceController {

    private String pathSessionsIdGame;

    public PlacePieceControllerWs(String sessionId) {
        super(sessionId);
        this.pathSessionsIdGame = SessionUris.PATH_SESSIONS + "/" + this.getSessionId()
                + SessionGameUris.PATH_GAME;
    }

    @Override
    public void placePiece(CoordinateEntity coordinate) {
        ControllerWs.buildWebServiceManager(pathSessionsIdGame, SessionGameUris.PATH_PIECE)
                .create(coordinate);
    }

    @Override
    public void placePiece(CoordinateEntity sourceCoordinate, CoordinateEntity destinationCoordinate) {
        WsManager webServicesManager = ControllerWs.buildWebServiceManager(pathSessionsIdGame,
                SessionGameUris.PATH_PIECE);
        webServicesManager.addMatrixParams("row", String.valueOf(sourceCoordinate.getRow()));
        webServicesManager.addMatrixParams("column", String.valueOf(sourceCoordinate.getColumn()));
        webServicesManager.delete();
        ControllerWs.buildWebServiceManager(pathSessionsIdGame, SessionGameUris.PATH_PIECE)
                .create(destinationCoordinate);
    }

}
