package es.art83.ticTacToe.controllers.ws;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.art83.ticTacToe.controllers.ws.ControllerWsFactory;
import es.art83.ticTacToe.controllers.ws.LoginControllerWs;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.ws.PlayerUris;
import es.art83.ticTacToe.ws.SessionUris;

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
        assertFalse(this.login.loggedIn());
    }

    @Test
    public void testLogged() {
        this.login.register(playerEntity);
        assertTrue(this.login.loggedIn());
    }

    @After
    public void after() {
        ControllerWs.buildWebServiceManager(SessionUris.PATH_SESSIONS, this.login.getSessionId()).delete();
        ControllerWs.buildWebServiceManager(PlayerUris.PATH_PLAYERS, this.playerEntity.getUser()).delete();
    }
}
