package es.art83.ticTacToe.controllers.ws.server;


import static org.junit.Assert.*;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

public class SessionResourceTest {
    private Response response;

    private Integer id;

    protected WebTarget getWebTarget() {
        return ClientBuilder.newClient().target("http://localhost:8080/TicTacToe").path("rest")
                .path("sessions");
    }

    @Before
    public void before() {
        this.response = this.getWebTarget().request().post(null);
        this.id = this.response.readEntity(Integer.class);
    }

    @Test
    public void testCreate() {
        assertEquals(Response.Status.Family.SUCCESSFUL, response.getStatusInfo().getFamily());
        assertNotNull(this.id);
        assertNotEquals(new Integer(0), this.id);
    }

    @Test
    public void testLoggedOut() {
        Response response = this.getWebTarget().path(String.valueOf(this.id)).path("logged")
                .request().get();
        assertFalse(Boolean.valueOf(response.readEntity(String.class)));
    }

    @Test
    public void testState() {
        Response response = this.getWebTarget().path(String.valueOf(this.id)).path("state")
                .request().get();
        TicTacToeStateModel state = response.readEntity(TicTacToeStateModel.class);
        assertEquals(TicTacToeStateModel.INITIAL, state);
    }

    @Test
    public void testSavedGame() {
        Response response = this.getWebTarget().path(String.valueOf(this.id)).path("savedGame")
                .request().get();
        assertTrue(Boolean.valueOf(response.readEntity(String.class)));
    }

    @After
    public void after() {
        this.getWebTarget().path(String.valueOf(this.id)).request().delete();
    }

}
