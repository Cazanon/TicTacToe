package es.art83.ticTacToe.views.web.beans;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;

import es.art83.ticTacToe.controllers.LoginController;

@ManagedBean
public class LoginViewBean extends PlayerViewBean {
    private boolean loggedOut;

    @PostConstruct
    public void update() {
        LoginController loginController = this.getControllerFactory().getLoginController();
        this.loggedOut = loginController.loggedOut();
    }

    public boolean isLogouted() {
        return this.loggedOut;
    }

    public String login() {
        String next = null;
        LoginController loginController = this.getControllerFactory().getLoginController();
        boolean ok = loginController.login(this.getPlayer());
        if (!ok) {
            FacesContext.getCurrentInstance().addMessage("loginViewBean",
                    new FacesMessage("usuario o clave incorrecta"));
        } else {
            LogManager.getLogger(this.getClass().getName()).info(
                    "--- Usuario Logeado: " + this.getPlayer().toString() + " ---");

            next = "logged/game";
        }
        return next;
    }

}
