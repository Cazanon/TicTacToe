package es.art83.ticTacToe.webService;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.webService.utils.WS;
import es.art83.ticTacToe.webService.utils.WebServicesManager;

public class SessionPlayerResourceTest {
    private String sessionId;

    private PlayerEntity player;

    @Before
    public void before() {
        WebServicesManager<String> webService = new WebServicesManager<>(
                WS.PATH_SESSIONS);
        webService.create();
        this.sessionId = webService.entity(String.class);

        this.player = new PlayerEntity("u", "pass");
        new WebServicesManager<>(WS.PATH_PLAYERS).create(player);
    }

    @Test
    public void testLoginPlayerExist() {
        assertTrue(new WebServicesManager<>(WS.PATH_SESSIONS, this.sessionId,
                WS.PATH_PLAYER).create(player));
    }

    @Test
    public void testLoginPlayerNotExist() {
        PlayerEntity player2 = new PlayerEntity("u2", "upass");
        assertFalse(new WebServicesManager<>(WS.PATH_SESSIONS, this.sessionId,
                WS.PATH_PLAYER).create(player2));
    }

    @Test
    public void testLoginPlayerNotPass() {
        PlayerEntity player2 = new PlayerEntity("u", "no");
        assertFalse(new WebServicesManager<>(WS.PATH_SESSIONS, this.sessionId,
                WS.PATH_PLAYER).create(player2));
    }

    public void testLogoutPlayer() {
        fail("No implementado");
    }

    public void testGameNames() {
        fail("No implementado");
    }

    @After
    public void after() {
        new WebServicesManager<>(WS.PATH_SESSIONS, this.sessionId).delete();
        new WebServicesManager<>(WS.PATH_PLAYERS, this.player.getUser()).delete();
    }

}
