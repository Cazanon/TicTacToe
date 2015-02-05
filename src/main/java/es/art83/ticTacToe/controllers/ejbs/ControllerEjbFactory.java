package es.art83.ticTacToe.controllers.ejbs;

import es.art83.ticTacToe.controllers.ControllerFactory;
import es.art83.ticTacToe.controllers.CreateGameController;
import es.art83.ticTacToe.controllers.LoginController;
import es.art83.ticTacToe.controllers.LogoutController;
import es.art83.ticTacToe.controllers.OpenGameController;
import es.art83.ticTacToe.controllers.PlacePieceController;
import es.art83.ticTacToe.controllers.SaveGameController;
import es.art83.ticTacToe.controllers.ShowGameController;

//@ManagedBean(name = "controllerFactory")
//@SessionScoped
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
        // TODO podrían pasar a ser singleton en sus getXXX
        loginController = new LoginControllerEjb(ticTacToeSession);
        logoutController = new LogoutControllerEjb(ticTacToeSession);
        createGameController = new CreateGameControllerEjb(ticTacToeSession);
        showGameController = new ShowGameControllerEjb(ticTacToeSession);
        placePieceController = new PlacePieceControllerEjb(ticTacToeSession);
        saveGameController = new SaveGameControllerEjb(ticTacToeSession);
        openGameController = new OpenGameControllerEjb(ticTacToeSession);
    }

    @Override
    public LoginController getLoginController() {
        return loginController;
    }

    @Override
    public LogoutController getLogoutController() {
        return logoutController;
    }

    @Override
    public CreateGameController getCreateGameControler() {
        return createGameController;
    }

    @Override
    public OpenGameController getOpenGameController() {
        return openGameController;
    }

    @Override
    public ShowGameController getShowGameController() {
        return showGameController;
    }

    @Override
    public PlacePieceController getPlacePieceController() {
        return placePieceController;
    }

    @Override
    public SaveGameController getSaveGameController() {
        return saveGameController;
    }

}
