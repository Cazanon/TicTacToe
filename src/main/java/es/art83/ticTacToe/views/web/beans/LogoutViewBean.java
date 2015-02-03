package es.art83.ticTacToe.views.web.beans;

import javax.faces.bean.ManagedBean;

import org.apache.logging.log4j.LogManager;

import es.art83.ticTacToe.controllers.LogoutController;

@ManagedBean
public class LogoutViewBean extends PlayerViewBean {
    public String logout() {
        LogoutController logoutController = this.getControllerFactory().getLogoutController();
        logoutController.logout();
        LogManager.getLogger(this.getClass().getName()).info("--- logout ---");
        return "/login";
    }

}
