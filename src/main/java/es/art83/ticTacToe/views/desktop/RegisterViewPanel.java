package es.art83.ticTacToe.views.desktop;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import es.art83.ticTacToe.models.entities.PlayerEntity;

@SuppressWarnings("serial")
class RegisterViewPanel extends UserViewPanel {

    private JLabel repeatedPasswordMsg;

    private JPasswordField repeatedPassword;

    private JButton cancel;

    private JButton register;

    RegisterViewPanel(Frame frame) {
        super(frame);
    }

    @Override
    protected void createComponents() {
        super.createComponents();
        repeatedPasswordMsg = this.createLabelInPanel("Repeated Password: ");
        repeatedPassword = this.createPasswordFieldInPanel(FIELD_LENGTH);
        register = this.createButtonInPanel("Register");
        cancel = this.createButtonInPanel("Cancel");
    }

    @Override
    protected void visualizeComponents() {
        super.visualizeComponents();
        repeatedPasswordMsg.setVisible(true);
        repeatedPassword.setVisible(true);
        register.setVisible(true);
        cancel.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == register) {
            if (user.getText().equals("")
                    || password.getPassword().length == 0
                    || repeatedPassword.getPassword().length == 0
                    || !new String(password.getPassword()).equals(new String(repeatedPassword
                            .getPassword()))) {
                JOptionPane.showMessageDialog(null,
                        "The user can not be empty and passwords must match");
            } else {
                boolean result = loginController.register(new PlayerEntity(user.getText(),
                        new String(password.getPassword())));
                if (result) {
                    frame.setPanel(new GameViewPanel(frame));
                }
            }
        } else if (event.getSource() == cancel) {
            frame.setPanel(new LoginViewPanel(frame));
        }
    }
}
