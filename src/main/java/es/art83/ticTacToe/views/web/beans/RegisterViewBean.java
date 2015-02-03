package es.art83.ticTacToe.views.web.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;

import es.art83.ticTacToe.controllers.LoginController;

@ManagedBean
public class RegisterViewBean extends PlayerViewBean {
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password2) {
        this.password = password2;
    }

    public String register() {
        String next = null;
        LoginController loginController = this.getControllerFactory().getLoginController();
        if (!this.getPlayer().getPassword().equals(this.password)) {
            FacesContext.getCurrentInstance().addMessage("registerViewBean:password",
                    new FacesMessage("Claves direrentes"));
        } else {
            boolean ok = loginController.register(this.getPlayer());
            if (!ok) {
                FacesContext.getCurrentInstance().addMessage("registerViewBean:user",
                        new FacesMessage("Usuario ya registrado"));
            } else {
                LogManager.getLogger(this.getClass().getName()).info(
                        "--- Usuario Registrado: " + this.getPlayer().toString() + " ---");
                next = "logged/game";
            }
        }
        return next;
    }

}
