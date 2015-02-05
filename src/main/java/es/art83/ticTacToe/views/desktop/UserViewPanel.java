package es.art83.ticTacToe.views.desktop;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import es.art83.ticTacToe.controllers.LoginController;

@SuppressWarnings("serial")
abstract class UserViewPanel extends ViewPanel {

    protected LoginController loginController;
    
    protected JLabel userMsg;
    
    protected JTextField user;

    protected JLabel passwordMsg;
    
    protected JPasswordField password;

    protected UserViewPanel(Frame frame){
        super(frame);
    }
    
    @Override
    protected void updateControllers() {
        loginController = factory.getLoginController();
    }
    
    @Override
    protected void createComponents(){
        userMsg = this.createLabelInPanel("User: ");
        user = this.createTextFieldInPanel(15);
        passwordMsg = this.createLabelInPanel("Password: ");
        password = this.createPasswordFieldInPanel(FIELD_LENGTH);
    }
    
    @Override
    protected void updateComponents(){
        
    }
 
    @Override
    protected void visualizeComponents() {
        userMsg.setVisible(true);
        user.setVisible(true);
        passwordMsg.setVisible(true);
        password.setVisible(true);
    }

}
