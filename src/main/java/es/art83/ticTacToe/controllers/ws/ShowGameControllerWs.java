package es.art83.ticTacToe.controllers.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.GenericType;

import es.art83.ticTacToe.controllers.ShowGameController;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.entities.PieceEntity;
import es.art83.ticTacToe.models.utils.ColorModel;
import es.art83.ticTacToe.models.utils.ListStringWrapper;
import es.art83.ticTacToe.webService.SessionGameResource;
import es.art83.ticTacToe.webService.SessionPlayerResource;
import es.art83.ticTacToe.webService.SessionResource;
import es.art83.ticTacToe.webService.utils.WebServicesManager;

public class ShowGameControllerWs extends ControllerWebService implements
        ShowGameController {
    private final String pathSessionsIdGame;

    public ShowGameControllerWs(String sessionId) {
        super(sessionId);
        this.pathSessionsIdGame = SessionResource.PATH_SESSIONS + "/" + this.getSessionId()
                + SessionGameResource.PATH_GAME;
    }

    @Override
    public String gameName() {
        return new WebServicesManager<String>(pathSessionsIdGame, SessionGameResource.PATH_NAME)
                .entity(String.class);
    }

    @Override
    public List<PieceEntity> allPieces() {
        GenericType<List<PieceEntity>> gerericType = new GenericType<List<PieceEntity>>() {
        };
        List<PieceEntity> allPieces = new WebServicesManager<PieceEntity>(pathSessionsIdGame,
                SessionGameResource.PATH_ALL_PIECES).entities(gerericType);
        return allPieces;
    }

    @Override
    public ColorModel gameOver() {
        return new WebServicesManager<ColorModel>(pathSessionsIdGame,
                SessionGameResource.PATH_GAME_OVER).entity(ColorModel.class);
    }

    @Override
    public ColorModel turnColor() {
        return new WebServicesManager<ColorModel>(pathSessionsIdGame, SessionGameResource.PATH_TURN)
                .entity(ColorModel.class);
    }

    @Override
    public boolean hasAllPieces() {
        return new WebServicesManager<Boolean>(pathSessionsIdGame,
                SessionGameResource.PATH_HAS_ALL_PIECES).entityBoolean();
    }

    @Override
    public List<CoordinateEntity> validSourceCoordinates() {
        GenericType<List<CoordinateEntity>> gerericType = new GenericType<List<CoordinateEntity>>() {
        };
        return new WebServicesManager<CoordinateEntity>(pathSessionsIdGame,
                SessionGameResource.PATH_VALID_SOURCE_COORDINATES).entities(gerericType);
    }

    @Override
    public List<CoordinateEntity> validDestinationCoordinates() {
        GenericType<List<CoordinateEntity>> gerericType = new GenericType<List<CoordinateEntity>>() {
        };
        return new WebServicesManager<CoordinateEntity>(pathSessionsIdGame,
                SessionGameResource.PATH_VALID_DESTINATION_COORDINATES).entities(gerericType);
    }

    @Override
    public boolean openedGame() {
        return new WebServicesManager<Boolean>(SessionResource.PATH_SESSIONS, this.getSessionId(),
                SessionResource.PATH_CREATED_GAME).entityBoolean();
    }

    @Override
    public List<String> gameNames() {
        ListStringWrapper listStringWrapper = new WebServicesManager<ListStringWrapper>(
                SessionResource.PATH_SESSIONS, this.getSessionId(),
                SessionPlayerResource.PATH_PLAYER, SessionPlayerResource.PATH_GAME_NAMES)
                .entity(ListStringWrapper.class);
        List<String> list = listStringWrapper.getListString();
        if (list == null) {
            list = new ArrayList<String>();
        }
        return list;
    }

}
