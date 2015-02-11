package es.art83.ticTacToe.controllers.ws;

import es.art83.ticTacToe.controllers.ControllerFactory;
import es.art83.ticTacToe.controllers.CreateGameController;
import es.art83.ticTacToe.controllers.LoginController;
import es.art83.ticTacToe.controllers.LogoutController;
import es.art83.ticTacToe.controllers.OpenGameController;
import es.art83.ticTacToe.controllers.PlacePieceController;
import es.art83.ticTacToe.controllers.SaveGameController;
import es.art83.ticTacToe.controllers.ShowGameController;
import es.art83.ticTacToe.ws.SessionResource;

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

    private String sessionId = null;

    public ControllerWsFactory() {
        // Crear peticion rest para crear contexto. Almacenar la referencia del
        // contexto en el servidor
        WsManager webServicesManager = ControllerWs.buildWebServiceManager(SessionResource.PATH_SESSIONS);
//                new WebServicesManager<>(
//                SessionResource.PATH_SESSIONS);
        webServicesManager.create();
        sessionId = webServicesManager.entity(String.class);
    }

    @Override
    public LoginController getLoginController() {
        if (loginController == null) {
            loginController = new LoginControllerWs(sessionId);
        }
        return loginController;
    }

    @Override
    public LogoutController getLogoutController() {
        if (logoutController == null) {
            logoutController = new LogoutControllerWs(sessionId);
        }
        return logoutController;
    }

    @Override
    public CreateGameController getCreateGameControler() {
        if (createGameController == null) {
            createGameController = new CreateGameControllerWs(sessionId);
        }
        return createGameController;
    }

    @Override
    public OpenGameController getOpenGameController() {
        if (openGameController == null) {
            openGameController = new OpenGameControllerWs(sessionId);
        }
        return openGameController;
    }

    @Override
    public ShowGameController getShowGameController() {
        if (showGameController == null) {
            showGameController = new ShowGameControllerWs(sessionId);
        }
        return showGameController;
    }

    @Override
    public PlacePieceController getPlacePieceController() {
        if (placePieceController == null) {
            placePieceController = new PlacePieceControllerWs(sessionId);
        }
        return placePieceController;
    }

    @Override
    public SaveGameController getSaveGameController() {
        if (saveGameController == null) {
            saveGameController = new SaveGameControllerWs(sessionId);
        }
        return saveGameController;
    }

}
