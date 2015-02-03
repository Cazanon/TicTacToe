package es.art83.ticTacToe.views.desktop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import es.art83.ticTacToe.models.entities.PlayerEntity;

public class RegisterViewPanel extends ViewPanel implements ActionListener {

    private JTextField user;

    private JPasswordField password;

    private JPasswordField repeatedPassword;

    private JButton cancel;

    private JButton register;

    RegisterViewPanel(Frame frame) {
        super(frame);
        this.add(new JLabel("User:"));
        user = new JTextField(15);
        this.add(user);
        this.add(new JLabel("Password:"));
        password = new JPasswordField(15);
        this.add(password);
        this.add(new JLabel("Repeated password:"));
        repeatedPassword = new JPasswordField(15);
        this.add(repeatedPassword);
        register = new JButton("Register");
        this.add(register);
        register.addActionListener(this);
        cancel = new JButton("Cancel");
        this.add(cancel);
        cancel.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == register) {
            if (user.getText().equals("")
                    || !new String(password.getPassword())
                            .equals(new String(repeatedPassword.getPassword()))) {
                JOptionPane.showMessageDialog(null,
                        "The user can not be empty and passwords must match");
            } else {
                boolean result = factory.getLoginController().register(
                        new PlayerEntity(user.getText(), new String(password.getPassword())));
                if (result) {
                    frame.update(new GameViewPanel(frame));
                }
            }
        } else if (event.getSource() == cancel) {
            frame.update(new LoginViewPanel(frame));
        }
    }
}
