package es.art83.ticTacToe.ws;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.art83.ticTacToe.controllers.ws.WsManager;
import es.art83.ticTacToe.models.entities.PlayerEntity;

public class SessionPlayerResourceTest extends ResourceTest {
    private String sessionId;

    private PlayerEntity player;

    @Before
    public void before() {
        WsManager webService = new WsManager(URI,
                SessionUris.PATH_SESSIONS);
        webService.create();
        this.sessionId = webService.entity(String.class);

        this.player = new PlayerEntity("u", "pass");
        new WsManager(URI,PlayerUris.PATH_PLAYERS).create(player);
    }

    @Test
    public void testLoginPlayerExist() {
        assertTrue(new WsManager(URI,SessionUris.PATH_SESSIONS, this.sessionId,
                SessionPlayerUris.PATH_PLAYER).create(player));
    }

    @Test
    public void testLoginPlayerNotExist() {
        PlayerEntity player2 = new PlayerEntity("u2", "upass");
        assertFalse(new WsManager(URI,SessionUris.PATH_SESSIONS, this.sessionId,
                SessionPlayerUris.PATH_PLAYER).create(player2));
    }

    @Test
    public void testLoginPlayerNotPass() {
        PlayerEntity player2 = new PlayerEntity("u", "no");
        assertFalse(new WsManager(URI,SessionUris.PATH_SESSIONS, this.sessionId,
                SessionPlayerUris.PATH_PLAYER).create(player2));
    }

    public void testLogoutPlayer() {
        fail("No implementado");
    }

    public void testGameNames() {
        fail("No implementado");
    }

    @After
    public void after() {
        new WsManager(URI,SessionUris.PATH_SESSIONS, this.sessionId).delete();
        new WsManager(URI,PlayerUris.PATH_PLAYERS, this.player.getUser()).delete();
    }

}
