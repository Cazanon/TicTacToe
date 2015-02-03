package es.art83.ticTacToe.views.desktop;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import es.art83.ticTacToe.controllers.CreateGameController;
import es.art83.ticTacToe.controllers.LogoutController;
import es.art83.ticTacToe.controllers.OpenGameController;
import es.art83.ticTacToe.controllers.PlacePieceController;
import es.art83.ticTacToe.controllers.SaveGameController;
import es.art83.ticTacToe.controllers.ShowGameController;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.entities.PieceEntity;
import es.art83.ticTacToe.models.utils.ColorModel;

@SuppressWarnings("serial")
class GameViewPanel extends ViewPanel {

    private ShowGameController showGameController;

    private SaveGameController saveGameController;

    private PlacePieceController placePieceController;

    private CreateGameController createGameControler;

    private OpenGameController openGameController;

    private LogoutController logoutController;

    private JLabel nameGameMsg;

    private JLabel boardMsg;

    private JLabel[] rows;

    private JButton saveGame;

    private JLabel turnMsg;

    private JComboBox<CoordinateEntity> validSourceCoordinates;

    private JComboBox<CoordinateEntity> validDestinationCoordinates;

    private JButton placePiece;

    private JLabel winnerMsg;

    private JButton createGame;

    private JComboBox<String> gameNames;

    private JButton openGame;

    private JButton logout;

    GameViewPanel(Frame frame) {
        super(frame);
    }

    @Override
    protected void updateControllers() {
        showGameController = factory.getShowGameController();
        saveGameController = factory.getSaveGameController();
        placePieceController = factory.getPlacePieceController();
        createGameControler = factory.getCreateGameControler();
        openGameController = factory.getOpenGameController();
        logoutController = factory.getLogoutController();
    }

    @Override
    protected void createComponents() {
        nameGameMsg = this.createLabelInPanel("");
        boardMsg = this.createLabelInPanel("Board");
        rows = new JLabel[CoordinateEntity.DIMENSION];
        for (int i = 0; i < CoordinateEntity.DIMENSION; i++) {
            rows[i] = this.createLabelInPanel("");
        }
        turnMsg = this.createLabelInPanel("");
        saveGame = this.createButtonInPanel("Save Game");
        validSourceCoordinates = this.createComboBoxInPanel();
        validDestinationCoordinates = this.createComboBoxInPanel();
        placePiece = this.createButtonInPanel("Place Piece");
        winnerMsg = this.createLabelInPanel("");
        createGame = this.createButtonInPanel("New Game");
        gameNames = this.createComboBoxInPanel();
        openGame = this.createButtonInPanel("Open Game");
        logout = this.createButtonInPanel("Logout");
    }

    @Override
    protected void updateComponents() {
        boolean createdGame = showGameController.createdGame();
        if (createdGame) {
            boolean hasAllPieces = showGameController.hasAllPieces();
            nameGameMsg = new JLabel("Name game:" + showGameController.gameName());
            ColorModel[][] colors = new ColorModel[3][3];
            for (PieceEntity ficha : showGameController.allPieces()) {
                colors[ficha.getCoordinateEntity().getRow()][ficha.getCoordinateEntity()
                        .getColumn()] = ficha.getColorModel();
            }
            for (int i = 0; i < CoordinateEntity.DIMENSION; i++) {
                String text = i + ": ";
                for (int j = 0; j < CoordinateEntity.DIMENSION; j++) {
                    if (colors[i][j] == null) {
                        text += ". ";
                    } else {
                        text += colors[i][j] + " ";
                    }
                }
                rows[i].setText(text);
            }
            ColorModel winner = showGameController.gameOver();
            if (winner != null) {
                winnerMsg.setText("The winner is " + winner);
            } else {
                turnMsg.setText("Turn: " + showGameController.turnColor());
                if (hasAllPieces) {
                    DefaultComboBoxModel<CoordinateEntity> validSourceCoordinatesModel = new DefaultComboBoxModel<CoordinateEntity>();
                    for (CoordinateEntity coordinate : showGameController.validSourceCoordinates()) {
                        validSourceCoordinatesModel.addElement(coordinate);
                    }
                    validSourceCoordinates.setModel(validSourceCoordinatesModel);
                }
                DefaultComboBoxModel<CoordinateEntity> validDestinationCoordinatesModel = new DefaultComboBoxModel<CoordinateEntity>();
                for (CoordinateEntity coordinate : showGameController.validDestinationCoordinates()) {
                    validDestinationCoordinatesModel.addElement(coordinate);
                }
                validDestinationCoordinates.setModel(validDestinationCoordinatesModel);
            }
        }
        List<String> gameNames = showGameController.gameNames();
        boolean existGames = gameNames.isEmpty();
        if (existGames) {
            DefaultComboBoxModel<String> gameNamesModel = new DefaultComboBoxModel<String>();
            for (String gameName : gameNames) {
                gameNamesModel.addElement(gameName);
            }
            this.gameNames.setModel(gameNamesModel);
        }
    }

    @Override
    protected void visualizeComponents() {
        boolean createdGame = showGameController.createdGame();
        nameGameMsg.setVisible(createdGame);
        boardMsg.setVisible(createdGame);
        for (int i = 0; i < CoordinateEntity.DIMENSION; i++) {
            rows[i].setVisible(createdGame);
        }
        saveGame.setVisible(createdGame);
        boolean gameOver = false;
        if (createdGame) {
            gameOver = showGameController.gameOver() != null;
        }
        turnMsg.setVisible(createdGame && !gameOver);
        validSourceCoordinates.setVisible(createdGame && !gameOver && showGameController.hasAllPieces());
        validDestinationCoordinates.setVisible(createdGame && !gameOver);
        placePiece.setVisible(createdGame && !gameOver);
        winnerMsg.setVisible(createdGame && gameOver);
        createGame.setVisible(true);
        boolean existGames = !showGameController.gameNames().isEmpty();
        gameNames.setVisible(existGames);
        openGame.setVisible(existGames);
        logout.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == logout) {
            logoutController.logout();
            frame.setPanel(new LoginViewPanel(frame));
        } else {
            if (event.getSource() == saveGame) {
                saveGameController.saveGame();
            } else if (event.getSource() == placePiece) {
                if (!showGameController.hasAllPieces()) {
                    placePieceController.placePiece((CoordinateEntity) validDestinationCoordinates
                            .getSelectedItem());
                } else {
                    placePieceController.placePiece(
                            (CoordinateEntity) validSourceCoordinates.getSelectedItem(),
                            (CoordinateEntity) validDestinationCoordinates.getSelectedItem());

                }
            } else if (event.getSource() == createGame) {
                createGameControler.createGame();
            } else if (event.getSource() == openGame) {
                openGameController.openGame((String) gameNames.getSelectedItem());
            }
            this.updateAndVisualizeComponents();
        }
    }
}
