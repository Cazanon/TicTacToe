package es.art83.TictacToe.controllers.ws.server;

import static org.junit.Assert.*;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.junit.Test;

import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

public class SessionResourceTest {
    private WebTarget getWebTarget() {
        return ClientBuilder.newClient().target("http://localhost:8080/TicTacToe").path("rest")
                .path("sessions");
    }

    @Test
    public void testCreate() {
        Response response = this.getWebTarget().request().post(null);
        assertEquals(Response.Status.Family.SUCCESSFUL, response.getStatusInfo().getFamily());
        Integer id = response.readEntity(Integer.class);
        assertNotNull(id);
        assertNotEquals(new Integer(0), id);
    }

    @Test
    public void testLoggedOut() {
        Integer id = this.getWebTarget().request().post(null).readEntity(Integer.class);
        Response response = this.getWebTarget().path(String.valueOf(id)).path("logged").request()
                .get();
        assertFalse(Boolean.valueOf(response.readEntity(String.class)));
    }

    @Test
    public void testState() {
        Integer id = this.getWebTarget().request().post(null).readEntity(Integer.class);
        Response response = this.getWebTarget().path(String.valueOf(id)).path("state").request()
                .get();
        TicTacToeStateModel state = response.readEntity(TicTacToeStateModel.class);
        assertEquals(TicTacToeStateModel.INITIAL, state);
    }

    @Test
    public void testSavedGame() {
        Integer id = this.getWebTarget().request().post(null).readEntity(Integer.class);
        Response response = this.getWebTarget().path(String.valueOf(id)).path("savedGame")
                .request().get();
        assertTrue(Boolean.valueOf(response.readEntity(String.class)));
    }

}
