package es.art83.ticTacToe.controllers.webService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.art83.ticTacToe.controllers.LogoutController;
import es.art83.ticTacToe.controllers.webService.ControllerFactoryWSClient;
import es.art83.ticTacToe.controllers.webService.CreateControllerWSClient;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.webService.utils.TicTacToeResource;
import es.art83.ticTacToe.webService.utils.WebServiceClient;

public class CreateControllerWSClientTest {

    private CreateControllerWSClient create;

    private PlayerEntity playerEntity;

    private LogoutController logout;

    @Before
    public void before() {
        ControllerFactoryWSClient factory = new ControllerFactoryWSClient();
        this.create = (CreateControllerWSClient) factory.getCreateGameControler();
        this.logout = factory.getLogoutController();
        this.playerEntity = new PlayerEntity("u", "pass");
        factory.getLoginController().register(playerEntity);
    }

    @Test
    public void testCreateGame() {
        this.create.createGame();
    }

    @After
    public void after() {
        this.logout.logout();
        new WebServiceClient<>(TicTacToeResource.PATH_SESSIONS, this.create.getSessionId())
                .delete();
        new WebServiceClient<>(TicTacToeResource.PATH_PLAYERS, this.playerEntity.getUser())
                .delete();
    }
}
