package es.art83.ticTacToe.controllers.ws.server;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlayerResourceTest {
    private PlayerClient playerClient;

    @Before
    public void before() {
        this.playerClient = new PlayerClient();
    }

    @Test
    public void testCreateNoExist() {
        assertEquals(Response.Status.Family.SUCCESSFUL, this.playerClient.getResponse()
                .getStatusInfo().getFamily());
    }

    @Test
    public void testCreateExist() {
        assertEquals(Response.Status.CONFLICT.getStatusCode(), new PlayerClient().getResponse().getStatus());
    }

    @After
    public void after() {
        this.playerClient.close();
    }

}
