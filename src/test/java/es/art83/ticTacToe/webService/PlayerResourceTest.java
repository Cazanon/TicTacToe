package es.art83.ticTacToe.webService;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.art83.ticTacToe.controllers.ws.WebServicesManager;
import es.art83.ticTacToe.models.entities.PlayerEntity;

public class PlayerResourceTest extends ResourceTest {
    private PlayerEntity player;

    @Before
    public void before() {
        this.player = new PlayerEntity("u", "pass");
    }

    @Test
    public void testCreateNoExist() {
        assertTrue(new WebServicesManager(URI,PlayerResource.PATH_PLAYERS).create(player));
    }

    @Test
    public void testCreateExist() {
        new WebServicesManager(URI,PlayerResource.PATH_PLAYERS).create(player);
        assertFalse(new WebServicesManager(URI,PlayerResource.PATH_PLAYERS).create(player));
    }

    @After
    public void after() {
        new WebServicesManager(URI,PlayerResource.PATH_PLAYERS, this.player.getUser()).delete();
    }

}
