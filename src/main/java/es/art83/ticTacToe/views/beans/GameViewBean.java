package es.art83.ticTacToe.views.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.apache.logging.log4j.LogManager;

import es.art83.ticTacToe.controllers.CreateGameController;
import es.art83.ticTacToe.controllers.LogoutController;
import es.art83.ticTacToe.controllers.OpenGameController;
import es.art83.ticTacToe.controllers.PlacePieceController;
import es.art83.ticTacToe.controllers.SaveGameController;
import es.art83.ticTacToe.controllers.ShowGameController;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.utils.ColorModel;

@ManagedBean
public class GameViewBean extends ViewBean {

    private List<String> gameNames;

    private String gameNameSelected;

    private boolean createdGame;

    private String gameName;

    private ColorModel[][] colors;

    private boolean gameOver;

    private ColorModel winner;

    private boolean savedGame;

    private ColorModel turn;

    private boolean hasAllPieces;

    private List<CoordinateEntity> validSourceCoordinates;

    private String selectedSourceCoordinate;

    private List<CoordinateEntity> validDestinationCoordinates;

    private String selectedDestinationCoordinate;

    @PostConstruct
    public void update() {
        ShowGameController showGameController = this.getControllerFactory().getShowGameController();
        this.createdGame = showGameController.createdGame();
        if (this.createdGame) {
            this.gameName = showGameController.getNameGame();
            this.colors = showGameController.colors();
            this.gameOver = showGameController.gameOver();
            if (this.gameOver) {
                this.winner = showGameController.winner();
            } else {
                this.savedGame = showGameController.savedGame();
                this.turn = showGameController.turnColor();
                this.hasAllPieces = showGameController.hasAllPieces();
                if (this.hasAllPieces) {
                    this.validSourceCoordinates = showGameController.validSourceCoordinates();
                }
                this.validDestinationCoordinates = showGameController.validDestinationCoordinates();
            }
        }
        this.gameNames = this.getControllerFactory().getNameGameController().gameNames();
    }

    public String getGameNameSelected() {
        return gameNameSelected;
    }

    public void setGameNameSelected(String gameNameSelected) {
        this.gameNameSelected = gameNameSelected;
    }

    public List<String> getGameNames() {
        return this.gameNames;
    }

    public boolean isCreatedGame() {
        return this.createdGame;
    }

    public boolean isZeroGameNames() {
        return this.gameNames.size() == 0;
    }

    public boolean isGameNamed() {
        return this.gameName != null;
    }

    public String getGameName() {
        return this.gameName;
    }

    public ColorModel[][] getFichas() {
        return colors;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public ColorModel getWinner() {
        return winner;
    }

    public boolean isSavedGame() {
        return savedGame;
    }

    public ColorModel getTurn() {
        return turn;
    }

    public boolean isFullBoard() {
        return hasAllPieces;
    }

    public List<CoordinateEntity> getValidSourceCoordinates() {
        return validSourceCoordinates;
    }

    public String getSelectedSourceCoordinate() {
        return selectedSourceCoordinate;
    }

    public void setSelectedSourceCoordinate(String selectedSourceCoordinate) {
        this.selectedSourceCoordinate = selectedSourceCoordinate;
    }

    public List<CoordinateEntity> getValidDestinationCoordinates() {
        return validDestinationCoordinates;
    }

    public String getSelectedDestinationCoordinate() {
        return this.selectedDestinationCoordinate;
    }

    public void setSelectedDestinationCoordinate(String selectedDestinationCoordinate) {
        this.selectedDestinationCoordinate = selectedDestinationCoordinate;
    }

    // P R O C E S S -------- ---------- ---------- ---------- ----------
    public String createGame() {
        CreateGameController createGameController = this.getControllerFactory()
                .getCreateGameControler();
        createGameController.createGame();
        this.update();
        LogManager.getLogger("Bean:" + createGameController.getClass().getName()).info(
                "Created game");
        return null;
    }

    public String logout() {
        String next = null;
        LogoutController logoutController = this.getControllerFactory().getLogoutController();
        if (!logoutController.savedGame()) {
            next = "logout";
        } else {
            logoutController.logout();
            LogManager.getLogger("Bean:" + logoutController.getClass().getName()).info(
                    "Usuario cerrado");
            next = "/login";
        }
        return next;
    }

    public String placeCard() {
        PlacePieceController placeCardController = this.getControllerFactory()
                .getPlacePieceController();
        if (this.hasAllPieces) {
            placeCardController.placePiece(new CoordinateEntity(this.selectedSourceCoordinate),
                    new CoordinateEntity(this.selectedDestinationCoordinate));
        } else {
            placeCardController.placePiece(new CoordinateEntity(this.selectedDestinationCoordinate));
        }
        LogManager.getLogger("Bean:" + placeCardController.getClass().getName()).info(
                "Place card: " + this.selectedSourceCoordinate + ">"
                        + this.selectedDestinationCoordinate);
        this.update();
        return null;
    }

    public String saveGame() {
        String result = null;
        if (this.isGameNamed()) {
            SaveGameController saveGameController = this.getControllerFactory()
                    .getSaveGameController();
            saveGameController.saveGame();
            this.savedGame = true;
            LogManager.getLogger("Bean:" + saveGameController.getClass().getName()).info(
                    "Partida salvada: " + this.gameName);

        } else {
            result = "save";
        }
        return result;
    }

    public String openGame() {
        OpenGameController openGameController = this.getControllerFactory().getOpenGameController();
        openGameController.openGame(this.gameNameSelected);
        this.update();
        LogManager.getLogger("Bean:" + openGameController.getClass().getName()).info("openGame");
        return null;
    }

}
