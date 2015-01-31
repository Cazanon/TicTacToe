package es.art83.ticTacToe.controllers.webService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import es.art83.ticTacToe.controllers.ControllerFactory;
import es.art83.ticTacToe.controllers.CreateGameController;
import es.art83.ticTacToe.controllers.LoginController;
import es.art83.ticTacToe.controllers.LogoutController;
import es.art83.ticTacToe.controllers.NameGameController;
import es.art83.ticTacToe.controllers.OpenGameController;
import es.art83.ticTacToe.controllers.PlaceCardController;
import es.art83.ticTacToe.controllers.SaveGameController;
import es.art83.ticTacToe.controllers.ShowGameController;
import es.art83.ticTacToe.controllers.StartGameController;
import es.art83.ticTacToe.webService.utils.WS;
import es.art83.ticTacToe.webService.utils.WebServicesManager;

@ManagedBean(name = "controllerFactory")
@SessionScoped
public class ControllerFactoryWebService extends ControllerFactory {

    private LoginController loginController;

    private LogoutController logoutController;

    private StartGameController startGameController;

    private CreateGameController createGameController;

    private OpenGameController openGameController;

    private NameGameController nameGameController;

    private ShowGameController showGameController;

    private PlaceCardController placeCardController;

    private SaveGameController saveGameController;

    public ControllerFactoryWebService() {
        String sessionId = null;
        // Crear peticion rest para crear contexto. Almacenar la referencia del
        // contexto en el servidor
        WebServicesManager<String> webServiceClient = new WebServicesManager<>(WS.PATH_SESSIONS);
        webServiceClient.create();
        sessionId = webServiceClient.entity(String.class);

        // Pasarle la referencia a todos los controladores
        this.loginController = new LoginControllerWebService(sessionId);
        this.logoutController = new LogoutControllerWebService(sessionId);
        this.startGameController = new StartControllerWebService(sessionId);
        this.createGameController = new CreateControllerWebService(sessionId);
        this.nameGameController = new NameControllerWebService(sessionId);
        this.showGameController = new ShowGameControllerWebService(sessionId);
        this.placeCardController = new PlaceControllerWebService(sessionId);
        this.saveGameController = new SaveControllerWebService(sessionId);
        this.openGameController = new OpenControllerWebService(sessionId);
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
    public StartGameController getStartGameController() {
        return this.startGameController;
    }

    @Override
    public NameGameController getNameGameController() {
        return this.nameGameController;
    }

    @Override
    public ShowGameController getShowGameController() {
        return this.showGameController;
    }

    @Override
    public PlaceCardController getPlaceCardController() {
        return this.placeCardController;
    }

    @Override
    public SaveGameController getSaveGameController() {
        return this.saveGameController;
    }

}
