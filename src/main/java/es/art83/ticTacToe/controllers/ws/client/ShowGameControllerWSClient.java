package es.art83.ticTacToe.controllers.ws.client;

import java.util.List;

import es.art83.ticTacToe.controllers.ShowGameController;
import es.art83.ticTacToe.controllers.ws.client.utils.TicTacToeResource;
import es.art83.ticTacToe.controllers.ws.client.utils.WebServiceClient;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.entities.PieceEntity;
import es.art83.ticTacToe.models.utils.ColorModel;

public class ShowGameControllerWSClient extends ControllerWSClient implements ShowGameController {

    public ShowGameControllerWSClient(String sessionId) {
        super(sessionId);
    }

    @Override
    public String getNameGame() {
        WebServiceClient<String> webServiceClient = new WebServiceClient<>(
                TicTacToeResource.PATH_SESSIONS, this.getSessionId(), TicTacToeResource.PATH_GAME,
                TicTacToeResource.PATH_NAME);
        webServiceClient.read();
        return webServiceClient.entity(String.class);
    }

    @Override
    public ColorModel[][] colors() {
        WebServiceClient<PieceEntity> webServiceClient = new WebServiceClient<>(
                TicTacToeResource.PATH_SESSIONS, this.getSessionId(), TicTacToeResource.PATH_GAME,
                TicTacToeResource.PATH_ALL_PIECES);
        webServiceClient.read();
        List<PieceEntity> allPieces = webServiceClient.entities();
        ColorModel[][] matriz = new ColorModel[3][3];
        for (PieceEntity ficha : allPieces) {
            matriz[ficha.getCoordinate().getRow()][ficha.getCoordinate().getColumn()] = ficha
                    .getColor();
        }
        return matriz;
    }

    @Override
    public boolean isGameOver() {
        WebServiceClient<Boolean> webServiceClient = new WebServiceClient<>(
                TicTacToeResource.PATH_SESSIONS, this.getSessionId(), TicTacToeResource.PATH_GAME,
                TicTacToeResource.PATH_GAME_OVER);
        webServiceClient.read();
        return webServiceClient.entityBoolean();
    }

    @Override
    public ColorModel winner() {
        WebServiceClient<ColorModel> webServiceClient = new WebServiceClient<>(
                TicTacToeResource.PATH_SESSIONS, this.getSessionId(), TicTacToeResource.PATH_GAME,
                TicTacToeResource.PATH_WINNER);
        webServiceClient.read();
        return webServiceClient.entity(ColorModel.class);
    }

    @Override
    public boolean isSavedGame() {
        WebServiceClient<Boolean> webServiceClient = new WebServiceClient<>(
                TicTacToeResource.PATH_SESSIONS, this.getSessionId(),
                TicTacToeResource.PATH_SAVED_GAME);
        webServiceClient.read();
        return webServiceClient.entityBoolean();
    }

    @Override
    public ColorModel turnColor() {
        WebServiceClient<ColorModel> webServiceClient = new WebServiceClient<>(
                TicTacToeResource.PATH_SESSIONS, this.getSessionId(), TicTacToeResource.PATH_GAME,
                TicTacToeResource.PATH_TURN);
        webServiceClient.read();
        return webServiceClient.entity(ColorModel.class);
    }

    @Override
    public boolean hasAllPieces() {
        WebServiceClient<Boolean> webServiceClient = new WebServiceClient<>(
                TicTacToeResource.PATH_SESSIONS, this.getSessionId(),
                TicTacToeResource.PATH_HAS_ALL_PIECES);
        webServiceClient.read();
        return webServiceClient.entityBoolean();
    }

    @Override
    public List<CoordinateEntity> validSourceCoordinates() {
        WebServiceClient<CoordinateEntity> webServiceClient = new WebServiceClient<>(
                TicTacToeResource.PATH_SESSIONS, this.getSessionId(), TicTacToeResource.PATH_GAME,
                TicTacToeResource.PATH_VALID_SOURCE_COORDINATES);
        webServiceClient.read();
        return webServiceClient.entities();
    }

    @Override
    public List<CoordinateEntity> validDestinationCoordinates() {
        WebServiceClient<CoordinateEntity> webServiceClient = new WebServiceClient<>(
                TicTacToeResource.PATH_SESSIONS, this.getSessionId(), TicTacToeResource.PATH_GAME,
                TicTacToeResource.PATH_VALID_DESTINATION_COORDINATES);
        webServiceClient.read();
        return webServiceClient.entities();
    }

    @Override
    public boolean createdGame() {
        WebServiceClient<Boolean> webServiceClient = new WebServiceClient<>(
                TicTacToeResource.PATH_SESSIONS, this.getSessionId(),
                TicTacToeResource.PATH_CREATED_GAME);
        webServiceClient.read();
        return webServiceClient.entityBoolean();
    }

}
