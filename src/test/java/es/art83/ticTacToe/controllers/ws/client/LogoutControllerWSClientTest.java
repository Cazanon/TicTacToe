package es.art83.ticTacToe.controllers.ws.client;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.art83.ticTacToe.controllers.ws.client.ControllerFactoryWSClient;
import es.art83.ticTacToe.controllers.ws.client.LoginControllerWSClient;
import es.art83.ticTacToe.controllers.ws.client.utils.TicTacToeResource;
import es.art83.ticTacToe.controllers.ws.client.utils.WebServiceClient;
import es.art83.ticTacToe.models.entities.PlayerEntity;

public class LogoutControllerWSClientTest {

    private LoginControllerWSClient login;

    private LogoutControllerWSClient logout;

    private PlayerEntity playerEntity;

    @Before
    public void before() {
        ControllerFactoryWSClient factory = new ControllerFactoryWSClient();
        this.login = (LoginControllerWSClient) factory.getLoginController();
        this.logout = (LogoutControllerWSClient) factory.getLogoutController();
        this.playerEntity = new PlayerEntity("u", "pass");
        this.login.register(playerEntity);
    }

    @Test
    public void testIsSavedGame() {
        assertTrue(this.logout.isSavedGame());
    }

    @Test
    public void testLogout() {
        this.logout.logout();
        assertFalse(this.login.logged());
    }

    @Test
    public void testIsByeTrue() {
        this.logout.logout();
        assertTrue(this.logout.isBye());
    }

    @Test
    public void testIsByeFalse() {
        assertFalse(this.logout.isBye());
    }

    @After
    public void after() {
        new WebServiceClient<>(TicTacToeResource.PATH_SESSIONS, this.logout.getSessionId()).delete();
        new WebServiceClient<>(TicTacToeResource.PATH_PLAYERS, this.playerEntity.getUser()).delete();
    }
}
