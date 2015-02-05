package es.art83.ticTacToe.views.desktop;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import es.art83.ticTacToe.controllers.LogoutController;
import es.art83.ticTacToe.models.entities.PlayerEntity;

@SuppressWarnings("serial")
class LoginViewPanel extends UserViewPanel {

    private LogoutController logoutController;

    private JLabel byeMsg;

    private JButton login;

    private JButton register;

    LoginViewPanel(Frame frame) {
        super(frame);
    }

    @Override
    protected void updateControllers() {
        logoutController = factory.getLogoutController();
        super.updateControllers();
    }

    @Override
    protected void createComponents() {
        byeMsg = this.createLabelInPanel("Bye!");
        super.createComponents();
        login = this.createButtonInPanel("Login");
        register = this.createButtonInPanel("Register");
    }

    @Override
    protected void visualizeComponents() {
        byeMsg.setVisible(logoutController.logouted());
        super.visualizeComponents();
        login.setVisible(true);
        register.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == login) {
            this.login();
        } else if (event.getSource() == register) {
            this.register();
        } else {
            assert false;
        }
    }
    
    private void login(){
        boolean result = loginController.login(new PlayerEntity(user.getText(), new String(
                password.getPassword())));
        if (result) {
            frame.setPanel(new GameViewPanel(frame));
        } else {
            JOptionPane.showMessageDialog(null, "Unknow user! Try again");
        }
    }
    
    private void register(){
        frame.setPanel(new RegisterViewPanel(frame));
    }

}
