package es.art83.ticTacToe.controllers.webService;

import java.util.List;

import javax.ws.rs.core.GenericType;

import es.art83.ticTacToe.controllers.ShowGameController;
import es.art83.ticTacToe.controllers.webService.utils.TicTacToeResource;
import es.art83.ticTacToe.controllers.webService.utils.WebServiceClient;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.entities.PieceEntity;
import es.art83.ticTacToe.models.utils.ColorModel;

public class ShowGameControllerWSClient extends ControllerWSClient implements ShowGameController {
    private final String pathSessionsIdGame;

    public ShowGameControllerWSClient(String sessionId) {
        super(sessionId);
        this.pathSessionsIdGame = TicTacToeResource.PATH_SESSIONS + "/" + this.getSessionId()
                + TicTacToeResource.PATH_GAME;
    }

    @Override
    public String getNameGame() {
        return new WebServiceClient<String>(pathSessionsIdGame, TicTacToeResource.PATH_NAME)
                .entity(String.class);
    }

    @Override
    public ColorModel[][] colors() {
        GenericType<List<PieceEntity>> gerericType = new GenericType<List<PieceEntity>>() {
        };
        List<PieceEntity> allPieces = new WebServiceClient<PieceEntity>(pathSessionsIdGame,
                TicTacToeResource.PATH_ALL_PIECES).entities(gerericType);
        ColorModel[][] matriz = new ColorModel[3][3];
        for (PieceEntity ficha : allPieces) {
            matriz[ficha.getCoordinate().getRow()][ficha.getCoordinate().getColumn()] = ficha
                    .getColor();
        }
        return matriz;
    }

    @Override
    public boolean isGameOver() {
        return new WebServiceClient<Boolean>(pathSessionsIdGame, TicTacToeResource.PATH_GAME_OVER)
                .entityBoolean();
    }

    @Override
    public ColorModel winner() {
        return new WebServiceClient<ColorModel>(pathSessionsIdGame, TicTacToeResource.PATH_WINNER)
                .entity(ColorModel.class);
    }

    @Override
    public boolean isSavedGame() {
        return new WebServiceClient<Boolean>(TicTacToeResource.PATH_SESSIONS, this.getSessionId(),
                TicTacToeResource.PATH_SAVED_GAME).entityBoolean();
    }

    @Override
    public ColorModel turnColor() {
        return new WebServiceClient<ColorModel>(pathSessionsIdGame, TicTacToeResource.PATH_TURN)
                .entity(ColorModel.class);
    }

    @Override
    public boolean hasAllPieces() {
        return new WebServiceClient<Boolean>(pathSessionsIdGame,
                TicTacToeResource.PATH_HAS_ALL_PIECES).entityBoolean();
    }

    @Override
    public List<CoordinateEntity> validSourceCoordinates() {
        GenericType<List<CoordinateEntity>> gerericType = new GenericType<List<CoordinateEntity>>() {
        };
        return new WebServiceClient<CoordinateEntity>(pathSessionsIdGame,
                TicTacToeResource.PATH_VALID_SOURCE_COORDINATES).entities(gerericType);
    }

    @Override
    public List<CoordinateEntity> validDestinationCoordinates() {
        GenericType<List<CoordinateEntity>> gerericType = new GenericType<List<CoordinateEntity>>() {
        };
        return new WebServiceClient<CoordinateEntity>(pathSessionsIdGame,
                TicTacToeResource.PATH_VALID_DESTINATION_COORDINATES).entities(gerericType);
    }

    @Override
    public boolean createdGame() {
        return new WebServiceClient<Boolean>(TicTacToeResource.PATH_SESSIONS, this.getSessionId(),
                TicTacToeResource.PATH_CREATED_GAME).entityBoolean();
    }

}
