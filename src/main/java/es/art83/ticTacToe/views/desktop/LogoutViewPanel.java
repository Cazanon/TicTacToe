package es.art83.ticTacToe.views.desktop;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class LogoutViewPanel extends ViewPanel {

    private JLabel exitMsg;

    private JButton save;

    private JButton cancel;

    LogoutViewPanel(Frame frame) {
        super(frame);
    }

    @Override
    protected void updateControllers() {

    }

    @Override
    protected void createComponents() {
        exitMsg = this.createLabelInPanel("Do you want to save the game?");
        save = this.createButtonInPanel("Save Game");
        cancel = this.createButtonInPanel("Cancel");
    }

    @Override
    protected void updateComponents() {

    }

    @Override
    protected void visualizeComponents() {
        exitMsg.setVisible(true);
        save.setVisible(true);
        cancel.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == save) {

        } else if (event.getSource() == cancel) {

        } else {
            assert false;
        }
    }
}
