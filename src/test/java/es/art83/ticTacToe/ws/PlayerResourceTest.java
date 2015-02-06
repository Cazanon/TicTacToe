package es.art83.ticTacToe.ws;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.art83.ticTacToe.controllers.ws.WsManager;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.webService.PlayerResource;

public class PlayerResourceTest extends ResourceTest {
    private PlayerEntity player;

    @Before
    public void before() {
        this.player = new PlayerEntity("u", "pass");
    }

    @Test
    public void testCreateNoExist() {
        assertTrue(new WsManager(URI,PlayerResource.PATH_PLAYERS).create(player));
    }

    @Test
    public void testCreateExist() {
        new WsManager(URI,PlayerResource.PATH_PLAYERS).create(player);
        assertFalse(new WsManager(URI,PlayerResource.PATH_PLAYERS).create(player));
    }

    @After
    public void after() {
        new WsManager(URI,PlayerResource.PATH_PLAYERS, this.player.getUser()).delete();
    }

}
