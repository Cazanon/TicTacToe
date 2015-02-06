package es.art83.ticTacToe.controllers.ejbs;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import es.art83.ticTacToe.controllers.ControllerFactory;
import es.art83.ticTacToe.controllers.CreateGameController;
import es.art83.ticTacToe.controllers.LoginController;
import es.art83.ticTacToe.controllers.LogoutController;
import es.art83.ticTacToe.controllers.OpenGameController;
import es.art83.ticTacToe.controllers.PlacePieceController;
import es.art83.ticTacToe.controllers.SaveGameController;
import es.art83.ticTacToe.controllers.ShowGameController;

@ManagedBean(name = "controllerFactory")
@SessionScoped
public class ControllerEjbFactory extends ControllerFactory {

    private Session ticTacToeSession;

    private LoginController loginController;

    private LogoutController logoutController;

    private CreateGameController createGameController;

    private OpenGameController openGameController;

    private ShowGameController showGameController;

    private PlacePieceController placePieceController;

    private SaveGameController saveGameController;

    public ControllerEjbFactory() {
        ticTacToeSession = new Session();
    }

    @Override
    public LoginController getLoginController() {
        if (loginController == null) {
            loginController = new LoginControllerEjb(ticTacToeSession);
        }
        return loginController;
    }

    @Override
    public LogoutController getLogoutController() {
        if (logoutController == null) {
            logoutController = new LogoutControllerEjb(ticTacToeSession);
        }
        return logoutController;
    }

    @Override
    public CreateGameController getCreateGameControler() {
        if (createGameController == null) {
            createGameController = new CreateGameControllerEjb(ticTacToeSession);
        }
        return createGameController;
    }

    @Override
    public OpenGameController getOpenGameController() {
        if (openGameController == null) {
            openGameController = new OpenGameControllerEjb(ticTacToeSession);
        }
        return openGameController;
    }

    @Override
    public ShowGameController getShowGameController() {
        if (showGameController == null) {
            showGameController = new ShowGameControllerEjb(ticTacToeSession);
        }
        return showGameController;
    }

    @Override
    public PlacePieceController getPlacePieceController() {
        if (placePieceController == null) {
            placePieceController = new PlacePieceControllerEjb(ticTacToeSession);
        }
        return placePieceController;
    }

    @Override
    public SaveGameController getSaveGameController() {
        if (saveGameController == null) {
            saveGameController = new SaveGameControllerEjb(ticTacToeSession);
        }
        return saveGameController;
    }

}
