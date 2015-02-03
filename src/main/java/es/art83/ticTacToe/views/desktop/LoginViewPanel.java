package es.art83.ticTacToe.views.desktop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import es.art83.ticTacToe.models.entities.PlayerEntity;

class LoginViewPanel extends ViewPanel implements ActionListener {

    private JTextField user;

    private JPasswordField password;

    private JButton login;

    private JButton register;

    LoginViewPanel(Frame frame) {
        super(frame);
        if (factory.getLogoutController().logouted()) {
            this.add(new JLabel("Bye!"));
        }
        this.add(new JLabel("User:"));
        user = new JTextField(15);
        this.add(user);
        this.add(new JLabel("Password:"));
        password = new JPasswordField(15);
        this.add(password);
        login = new JButton("Login");
        this.add(login);
        login.addActionListener(this);
        register = new JButton("Register");
        this.add(register);
        register.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == login) {
            boolean result = factory.getLoginController().login(
                    new PlayerEntity(user.getText(), new String(password.getPassword())));
            if (result) {
                frame.update(new GameViewPanel(frame));
            } else {
                JOptionPane.showMessageDialog(null,
                        "The user can not be empty and passwords must match");
            }
        } else if (event.getSource() == register) {
            frame.update(new RegisterViewPanel(frame));
        }
    }

}
