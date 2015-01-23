package es.art83.ticTacToe.controllers.ws.server;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.art83.ticTacToe.models.entities.PlayerEntity;

public class SessionGameResourceTest extends SessionResourceTest {

    protected WebTarget getTargetGame() {
        return super.getTarget().path(String.valueOf(this.getId())).path("game");
    }

    @Before
    public void before() {
        super.before();
        ClientBuilder.newClient().target("http://localhost:8080/TicTacToe").path("rest")
                .path("players").request().post(Entity.xml(new PlayerEntity("u1", "upass")));
        this.getTarget().path(String.valueOf(this.getId())).path("player").request()
                .post(Entity.xml(new PlayerEntity("u1", "upass")));
    }

    @Test
    public void testCreateGameLogged() {
        Response response = this.getTargetGame().request().post(null);
        assertEquals(Response.Status.Family.SUCCESSFUL, response.getStatusInfo().getFamily());
    }

    @After
    public void after() {
        super.after();
        ClientBuilder.newClient().target("http://localhost:8080/TicTacToe").path("rest")
                .path("players").path("u1").request().delete();
    }

}
