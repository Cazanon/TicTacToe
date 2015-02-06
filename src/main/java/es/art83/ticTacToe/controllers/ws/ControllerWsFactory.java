package es.art83.ticTacToe.controllers.ws;

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

//@ManagedBean(name = "controllerFactory")
//@SessionScoped
public class ControllerWsFactory extends ControllerFactory {

    private LoginController loginController;

    private LogoutController logoutController;

    private CreateGameController createGameController;

    private OpenGameController openGameController;

    private ShowGameController showGameController;

    private PlacePieceController placePieceController;

    private SaveGameController saveGameController;

    public ControllerWsFactory() {
        String sessionId = null;
        // Crear peticion rest para crear contexto. Almacenar la referencia del
        // contexto en el servidor
        WebServicesManager<String> webServicesManager = new WebServicesManager<>(
                SessionResource.PATH_SESSIONS);
        webServicesManager.create();
        sessionId = webServicesManager.entity(String.class);

        // Pasarle la referencia a todos los controladores
        //TODO podrían pasar a ser singleton en sus getXXX
        this.loginController = new LoginControllerWs(sessionId);
        this.logoutController = new LogoutControllerWs(sessionId);
        this.createGameController = new CreateGameControllerWs(sessionId);
        this.showGameController = new ShowGameControllerWs(sessionId);
        this.placePieceController = new PlacePieceControllerWs(sessionId);
        this.saveGameController = new SaveGameControllerWs(sessionId);
        this.openGameController = new OpenGameControllerWs(sessionId);
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
