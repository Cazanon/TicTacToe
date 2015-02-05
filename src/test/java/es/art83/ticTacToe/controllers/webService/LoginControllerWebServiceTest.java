package es.art83.ticTacToe.controllers.webService;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.art83.ticTacToe.controllers.ws.ControllerWsFactory;
import es.art83.ticTacToe.controllers.ws.LoginControllerWs;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.webService.PlayerResource;
import es.art83.ticTacToe.webService.SessionResource;
import es.art83.ticTacToe.webService.utils.WebServicesManager;

public class LoginControllerWebServiceTest {

    private LoginControllerWs login;

    private PlayerEntity playerEntity;

    @Before
    public void before() {
        this.login = (LoginControllerWs) new ControllerWsFactory().getLoginController();
        this.playerEntity = new PlayerEntity("u", "pass");
    }

    @Test
    public void testRegisterNotExits() {
        assertTrue(this.login.register(playerEntity));
    }

    @Test
    public void testRegisterExits() {
        this.login.register(playerEntity);
        assertFalse(this.login.register(this.playerEntity));
    }

    @Test
    public void testNotLogged() {
        assertFalse(this.login.logged());
    }

    @Test
    public void testLogged() {
        this.login.register(playerEntity);
        assertTrue(this.login.logged());
    }

    @After
    public void after() {
        new WebServicesManager<>(SessionResource.PATH_SESSIONS, this.login.getSessionId()).delete();
        new WebServicesManager<>(PlayerResource.PATH_PLAYERS, this.playerEntity.getUser()).delete();
    }
}
