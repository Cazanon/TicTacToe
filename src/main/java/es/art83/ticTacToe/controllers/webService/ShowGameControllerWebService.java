package es.art83.ticTacToe.controllers.webService;

import java.util.List;

import javax.ws.rs.core.GenericType;

import es.art83.ticTacToe.controllers.ShowGameController;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.entities.PieceEntity;
import es.art83.ticTacToe.models.utils.ColorModel;
import es.art83.ticTacToe.webService.utils.WS;
import es.art83.ticTacToe.webService.utils.WebServicesManager;

public class ShowGameControllerWebService extends ControllerWebService implements ShowGameController {
    private final String pathSessionsIdGame;

    public ShowGameControllerWebService(String sessionId) {
        super(sessionId);
        this.pathSessionsIdGame = WS.PATH_SESSIONS + "/" + this.getSessionId()
                + WS.PATH_GAME;
    }

    @Override
    public String getNameGame() {
        return new WebServicesManager<String>(pathSessionsIdGame, WS.PATH_NAME)
                .entity(String.class);
    }

    @Override
    public ColorModel[][] colors() {
        GenericType<List<PieceEntity>> gerericType = new GenericType<List<PieceEntity>>() {
        };
        List<PieceEntity> allPieces = new WebServicesManager<PieceEntity>(pathSessionsIdGame,
                WS.PATH_ALL_PIECES).entities(gerericType);
        ColorModel[][] matriz = new ColorModel[3][3];
        for (PieceEntity ficha : allPieces) {
            matriz[ficha.getCoordinate().getRow()][ficha.getCoordinate().getColumn()] = ficha
                    .getColor();
        }
        return matriz;
    }

    @Override
    public boolean gameOver() {
        return new WebServicesManager<Boolean>(pathSessionsIdGame, WS.PATH_GAME_OVER)
                .entityBoolean();
    }

    @Override
    public ColorModel winner() {
        return new WebServicesManager<ColorModel>(pathSessionsIdGame, WS.PATH_WINNER)
                .entity(ColorModel.class);
    }

    @Override
    public boolean savedGame() {
        return new WebServicesManager<Boolean>(WS.PATH_SESSIONS, this.getSessionId(),
                WS.PATH_SAVED_GAME).entityBoolean();
    }

    @Override
    public ColorModel turnColor() {
        return new WebServicesManager<ColorModel>(pathSessionsIdGame, WS.PATH_TURN)
                .entity(ColorModel.class);
    }

    @Override
    public boolean hasAllPieces() {
        return new WebServicesManager<Boolean>(pathSessionsIdGame,
                WS.PATH_HAS_ALL_PIECES).entityBoolean();
    }

    @Override
    public List<CoordinateEntity> validSourceCoordinates() {
        GenericType<List<CoordinateEntity>> gerericType = new GenericType<List<CoordinateEntity>>() {
        };
        return new WebServicesManager<CoordinateEntity>(pathSessionsIdGame,
                WS.PATH_VALID_SOURCE_COORDINATES).entities(gerericType);
    }

    @Override
    public List<CoordinateEntity> validDestinationCoordinates() {
        GenericType<List<CoordinateEntity>> gerericType = new GenericType<List<CoordinateEntity>>() {
        };
        return new WebServicesManager<CoordinateEntity>(pathSessionsIdGame,
                WS.PATH_VALID_DESTINATION_COORDINATES).entities(gerericType);
    }

    @Override
    public boolean createdGame() {
        return new WebServicesManager<Boolean>(WS.PATH_SESSIONS, this.getSessionId(),
                WS.PATH_CREATED_GAME).entityBoolean();
    }

}
