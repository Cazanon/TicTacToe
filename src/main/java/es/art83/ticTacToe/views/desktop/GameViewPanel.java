package es.art83.ticTacToe.views.desktop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.entities.PieceEntity;
import es.art83.ticTacToe.models.utils.ColorModel;

public class GameViewPanel extends ViewPanel implements ActionListener {

    private JLabel nameGame;
    
    private JLabel board;

    private JLabel[] rows;

    private JButton saveGame;

    private JComboBox<CoordinateEntity> validSourceCoordinates;

    private JComboBox<CoordinateEntity> validDestinationCoordinates;

    private JButton placePiece;

    private JButton createGame;

    private JComboBox<String> gameNames;

    private JButton openGame;

    private JButton logout;

    GameViewPanel(Frame frame) {
        super(frame);
        nameGame = new JLabel();
        this.add(nameGame);
        board = new JLabel("Board");
        this.add(board);
        rows = new JLabel[CoordinateEntity.DIMENSION];
        for (int i = 0; i < CoordinateEntity.DIMENSION; i++) {
            rows[i] = new JLabel();
            this.add(rows[i]);
        }
        saveGame = new JButton("Save Game");
        this.add(saveGame);
        saveGame.addActionListener(this);
        validSourceCoordinates = new JComboBox<CoordinateEntity>();
        this.add(validSourceCoordinates);
        validDestinationCoordinates = new JComboBox<CoordinateEntity>();
        this.add(validDestinationCoordinates);
        placePiece = new JButton("Place Piece");
        this.add(placePiece);
        placePiece.addActionListener(this);
        createGame = new JButton("New Game");
        this.add(createGame);
        createGame.addActionListener(this);
        gameNames = new JComboBox<String>();
        this.add(gameNames);
        openGame = new JButton("Open Game");
        this.add(openGame);
        openGame.addActionListener(this);
        logout = new JButton("Logout");
        this.add(logout);
        logout.addActionListener(this);
        this.update();
    }

    private void update() {
        boolean createdGame = factory.getShowGameController().createdGame();
        if (createdGame) {
            nameGame = new JLabel("Name game:" + factory.getShowGameController().gameName());
            ColorModel[][] colors = new ColorModel[3][3];
            for (PieceEntity ficha : factory.getShowGameController().allPieces()) {
                colors[ficha.getCoordinateEntity().getRow()][ficha.getCoordinateEntity()
                        .getColumn()] = ficha.getColorModel();
            }
            for (int i = 0; i < CoordinateEntity.DIMENSION; i++) {
                String text = i+": ";
                for (int j = 0; j < CoordinateEntity.DIMENSION; j++) {
                    if (colors[i][j]==null) {
                        text += ". ";
                    } else {
                        text += colors[i][j] + " ";
                    }
                }
                rows[i].setText(text);
            }
            if (factory.getShowGameController().hasAllPieces()) {
                DefaultComboBoxModel<CoordinateEntity> validSourceCoordinatesModel = new DefaultComboBoxModel<CoordinateEntity>();
                System.out.println(factory.getShowGameController()
                        .validSourceCoordinates());
                for (CoordinateEntity coordinate : factory.getShowGameController()
                        .validSourceCoordinates()) {
                    validSourceCoordinatesModel.addElement(coordinate);
                }
                validDestinationCoordinates.setModel(validSourceCoordinatesModel);
            }
            DefaultComboBoxModel<CoordinateEntity> validDestinationCoordinatesModel = new DefaultComboBoxModel<CoordinateEntity>();
            System.out.println(factory.getShowGameController()
                    .validDestinationCoordinates());
            for (CoordinateEntity coordinate : factory.getShowGameController()
                    .validDestinationCoordinates()) {
                validDestinationCoordinatesModel.addElement(coordinate);
            }
            validDestinationCoordinates.setModel(validDestinationCoordinatesModel);
        }
        List<String> gameNames = factory.getShowGameController().gameNames();
        boolean existGames = gameNames.isEmpty();
        if (existGames) {
            DefaultComboBoxModel<String> gameNamesModel = new DefaultComboBoxModel<String>();
            for (String gameName : factory.getShowGameController().gameNames()) {
                gameNamesModel.addElement(gameName);
            }
            this.gameNames.setModel(gameNamesModel);
        }
        this.gameNames.setVisible(existGames);
        openGame.setVisible(existGames);
        this.setVisibleComponents(createdGame);
    }

    private void setVisibleComponents(boolean value) {
        nameGame.setVisible(value);
        board.setVisible(value);
        for (int i = 0; i < CoordinateEntity.DIMENSION; i++) {
            rows[i].setVisible(value);
        }
        saveGame.setVisible(value);
        validSourceCoordinates.setVisible(value && factory.getShowGameController().hasAllPieces());
        validDestinationCoordinates.setVisible(value);
        placePiece.setVisible(value);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == logout) {
            factory.getLogoutController().logout();
            frame.update(new LoginViewPanel(frame));
        } else {
            if (event.getSource() == saveGame) {
                factory.getSaveGameController().saveGame();
            } else if (event.getSource() == placePiece) {
                if (!factory.getShowGameController().hasAllPieces()) {
                    factory.getPlacePieceController().placePiece(
                            (CoordinateEntity) validDestinationCoordinates.getSelectedItem());
                } else {
                    factory.getPlacePieceController().placePiece(
                            (CoordinateEntity) validSourceCoordinates.getSelectedItem(),
                            (CoordinateEntity) validDestinationCoordinates.getSelectedItem());

                }
            } else if (event.getSource() == createGame) {
                factory.getCreateGameControler().createGame();
            } else if (event.getSource() == openGame) {
                factory.getOpenGameController().openGame((String) gameNames.getSelectedItem());
            }
            this.update();
        }
    }
}
