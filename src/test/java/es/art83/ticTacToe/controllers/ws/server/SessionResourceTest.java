package es.art83.ticTacToe.controllers.ws.server;

import static org.junit.Assert.*;

import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

public class SessionResourceTest {
    private SessionClient sessionClient;

    @Before
    public void createSession() {
        this.sessionClient = new SessionClient();
    }

    @Test
    public void testCreate() {
        assertEquals(Response.Status.Family.SUCCESSFUL, this.sessionClient.getResponse()
                .getStatusInfo().getFamily());
        assertNotNull(sessionClient.getId());
    }

    @Test
    public void testNotLogged() {
        Response response = this.sessionClient.resourceId().path("logged").request().get();
        assertFalse(Boolean.valueOf(response.readEntity(String.class)));
    }

    @Test
    public void testStateInitial() {
        Response response = this.sessionClient.resourceId().path("state").request().get();
        assertEquals(TicTacToeStateModel.INITIAL, response.readEntity(TicTacToeStateModel.class));
    }

    @Test
    public void testSavedGameInitial() {
        Response response = this.sessionClient.resourceId().path("savedGame").request().get();
        assertTrue(Boolean.valueOf(response.readEntity(String.class)));
    }

    @After
    public void deleteSession() {
        this.sessionClient.close();
    }

}
