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
public class ControllerFactoryEJB extends ControllerFactory {

    private TicTacToeSession ticTacToeSession;

    private LoginController loginController;

    private LogoutController logoutController;

    private CreateGameController createGameController;

    private OpenGameController openGameController;


    private ShowGameController showGameController;

    private PlacePieceController placePieceController;

    private SaveGameController saveGameController;

    public ControllerFactoryEJB() {
        this.ticTacToeSession = new TicTacToeSession();
        this.loginController = new LoginControllerEJB(ticTacToeSession);
        this.logoutController = new LogoutControllerEJB(ticTacToeSession);
        this.createGameController = new CreateGameControllerEJB(ticTacToeSession);
        this.showGameController = new ShowGameControllerEJB(ticTacToeSession);
        this.placePieceController = new PlacePieceControllerEJB(ticTacToeSession);
        this.saveGameController = new SaveGameControllerEJB(ticTacToeSession);
        this.openGameController = new OpenGameControllerEJB(ticTacToeSession);
    }

    @Override
    public LoginController getLoginController() {
        return this.loginController;
    }

    @Override
    public LogoutController getLogoutController() {
        return this.logoutController;
    }

    @Override
    public CreateGameController getCreateGameControler() {
        return createGameController;
    }

    @Override
    public OpenGameController getOpenGameController() {
        return this.openGameController;
    }

    @Override
    public ShowGameController getShowGameController() {
        return this.showGameController;
    }

    @Override
    public PlacePieceController getPlacePieceController() {
        return this.placePieceController;
    }

    @Override
    public SaveGameController getSaveGameController() {
        return this.saveGameController;
    }

}
