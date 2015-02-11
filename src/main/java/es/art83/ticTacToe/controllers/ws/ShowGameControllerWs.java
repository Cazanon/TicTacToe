package es.art83.ticTacToe.controllers.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.GenericType;

import es.art83.ticTacToe.controllers.ShowGameController;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.entities.PieceEntity;
import es.art83.ticTacToe.models.utils.ColorModel;
import es.art83.ticTacToe.models.utils.ListStringWrapper;
import es.art83.ticTacToe.ws.SessionGameUris;
import es.art83.ticTacToe.ws.SessionPlayerUris;
import es.art83.ticTacToe.ws.SessionUris;

public class ShowGameControllerWs extends ControllerWs implements
        ShowGameController {
    private final String pathSessionsIdGame;

    public ShowGameControllerWs(String sessionId) {
        super(sessionId);
        this.pathSessionsIdGame = SessionUris.PATH_SESSIONS + "/" + this.getSessionId()
                + SessionGameUris.PATH_GAME;
    }

    @Override
    public String gameName() {
        return ControllerWs.buildWebServiceManager(pathSessionsIdGame, SessionGameUris.PATH_NAME)
                .entity(String.class);
    }

    @Override
    public List<PieceEntity> piecesOnBoard() {
        GenericType<List<PieceEntity>> gerericType = new GenericType<List<PieceEntity>>() {
        };
        List<PieceEntity> allPieces = ControllerWs.buildWebServiceManager(pathSessionsIdGame,
                SessionGameUris.PATH_ALL_PIECES).entities(gerericType);
        return allPieces;
    }

    @Override
    public ColorModel gameOver() {
        return ControllerWs.buildWebServiceManager(pathSessionsIdGame,
                SessionGameUris.PATH_GAME_OVER).entity(ColorModel.class);
    }

    @Override
    public ColorModel turnColor() {
        return ControllerWs.buildWebServiceManager(pathSessionsIdGame, SessionGameUris.PATH_TURN)
                .entity(ColorModel.class);
    }

    @Override
    public boolean hasAllPieces() {
        return ControllerWs.buildWebServiceManager(pathSessionsIdGame,
                SessionGameUris.PATH_HAS_ALL_PIECES).entityBoolean();
    }

    @Override
    public List<CoordinateEntity> validSourceCoordinates() {
        GenericType<List<CoordinateEntity>> gerericType = new GenericType<List<CoordinateEntity>>() {
        };
        return ControllerWs.buildWebServiceManager(pathSessionsIdGame,
                SessionGameUris.PATH_VALID_SOURCE_COORDINATES).entities(gerericType);
    }

    @Override
    public List<CoordinateEntity> validDestinationCoordinates() {
        GenericType<List<CoordinateEntity>> gerericType = new GenericType<List<CoordinateEntity>>() {
        };
        return ControllerWs.buildWebServiceManager(pathSessionsIdGame,
                SessionGameUris.PATH_VALID_DESTINATION_COORDINATES).entities(gerericType);
    }

    @Override
    public boolean existGame() {
        return ControllerWs.buildWebServiceManager(SessionUris.PATH_SESSIONS, this.getSessionId(),
                SessionUris.PATH_CREATED_GAME).entityBoolean();
    }

    @Override
    public List<String> gameNamesOfPlayer() {
        ListStringWrapper listStringWrapper = ControllerWs.buildWebServiceManager(
                SessionUris.PATH_SESSIONS, this.getSessionId(),
                SessionPlayerUris.PATH_PLAYER, SessionPlayerUris.PATH_GAME_NAMES)
                .entity(ListStringWrapper.class);
        List<String> list = listStringWrapper.getListString();
        if (list == null) {
            list = new ArrayList<String>();
        }
        return list;
    }

}
