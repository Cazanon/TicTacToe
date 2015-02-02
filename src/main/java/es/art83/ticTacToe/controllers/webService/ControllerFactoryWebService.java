package es.art83.ticTacToe.controllers.webService;

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
import es.art83.ticTacToe.webService.SessionResource;
import es.art83.ticTacToe.webService.utils.WebServicesManager;

@ManagedBean(name = "controllerFactory")
@SessionScoped
public class ControllerFactoryWebService extends ControllerFactory {

    private LoginController loginController;

    private LogoutController logoutController;

    private CreateGameController createGameController;

    private OpenGameController openGameController;

    private ShowGameController showGameController;

    private PlacePieceController placePieceController;

    private SaveGameController saveGameController;

    public ControllerFactoryWebService() {
        String sessionId = null;
        // Crear peticion rest para crear contexto. Almacenar la referencia del
        // contexto en el servidor
        WebServicesManager<String> webServicesManager = new WebServicesManager<>(
                SessionResource.PATH_SESSIONS);
        webServicesManager.create();
        sessionId = webServicesManager.entity(String.class);

        // Pasarle la referencia a todos los controladores
        this.loginController = new LoginControllerWebService(sessionId);
        this.logoutController = new LogoutControllerWebService(sessionId);
        this.createGameController = new CreateGameControllerWebService(sessionId);
        this.showGameController = new ShowGameControllerWebService(sessionId);
        this.placePieceController = new PlacePieceControllerWebService(sessionId);
        this.saveGameController = new SaveGameControllerWebService(sessionId);
        this.openGameController = new OpenGameControllerWebService(sessionId);
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
