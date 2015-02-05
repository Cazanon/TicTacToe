package es.art83.ticTacToe.views.desktop;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import es.art83.ticTacToe.controllers.SaveGameController;
import es.art83.ticTacToe.controllers.ShowGameController;

@SuppressWarnings("serial")
public class SaveViewPanel extends ViewPanel {

    private SaveGameController saveGameController;
    
    private ShowGameController showGameController;

    private JLabel gameNameMsg;

    private JTextField gameName;

    private JButton save;

    private JButton overwrite;

    private JButton cancel;

    private boolean duplicated;

    SaveViewPanel(Frame frame) {
        super(frame);
    }

    @Override
    protected void updateControllers() {
        duplicated = false;
        saveGameController = factory.getSaveGameController();
        showGameController = factory.getShowGameController();
    }

    @Override
    protected void createComponents() {
        gameNameMsg = this.createLabelInPanel("Game name:");
        gameName = this.createTextFieldInPanel(FIELD_LENGTH);
        save = this.createButtonInPanel("Save Game");
        overwrite = this.createButtonInPanel("Overwrite Game");
        cancel = this.createButtonInPanel("Cancel");
    }

    @Override
    protected void updateComponents() {

    }

    @Override
    protected void visualizeComponents() {
        gameNameMsg.setVisible(true);
        gameName.setVisible(true);
        save.setVisible(!duplicated);
        overwrite.setVisible(duplicated);
        cancel.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == save) {
            this.save();
        } else if (event.getSource() == cancel) {
            this.cancel();
        } else {
            assert false;
        }
    }

    private void save() {
        if (gameName.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Game name can't be empty!");
        } else {
            if (!showGameController.gameNames().contains(gameName)) { // nombre no duplicado
                saveGameController.saveGame(gameName.getText());
            } else {
                duplicated = true;
                saveGameController.overWriteGame(gameName.getText());
            }
            frame.setPanel(new GameViewPanel(frame));
        }
    }

    private void cancel() {
        if (duplicated) {
            duplicated = false;
            this.updateAndVisualizeComponents();
        } else {
            frame.setPanel(new GameViewPanel(frame));
        }
    }
}
