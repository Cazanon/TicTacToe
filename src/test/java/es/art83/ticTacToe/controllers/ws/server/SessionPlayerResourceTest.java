package es.art83.ticTacToe.controllers.ws.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.art83.ticTacToe.models.entities.PlayerEntity;

public class SessionPlayerResourceTest extends SessionResourceTest{

    protected WebTarget getTargetPlayer() {
        return super.getTarget().path(String.valueOf(this.getId())).path("player");
    }

    @Before
    public void before() {
        super.before();
        ClientBuilder.newClient().target("http://localhost:8080/TicTacToe").path("rest")
                .path("players").request().post(Entity.xml(new PlayerEntity("u1", "upass")));
    }

    @Test
    public void testCreatePlayerExist() {
        Response response = this.getTargetPlayer().request()
                .post(Entity.xml(new PlayerEntity("u1", "upass")));
        assertEquals(Response.Status.Family.SUCCESSFUL, response.getStatusInfo().getFamily());
    }

    @Test
    public void testCreatePlayerNotExist() {
        Response response = this.getTargetPlayer().request()
                .post(Entity.xml(new PlayerEntity("u2", "upass")));
        assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
    }

    @Test
    public void testCreatePlayerNotPass() {
        Response response = this.getTargetPlayer().request()
                .post(Entity.xml(new PlayerEntity("u1", "no")));
        assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
    }

    @Test
    public void testDeletePlayer() {
        this.getTargetPlayer().request().post(Entity.xml(new PlayerEntity("u1", "upass")));
        this.getTargetPlayer().request().delete();
        this.testLoggedOut();
    }
    
    @Test
    public void testGameNames(){
        fail("No implementado");
    }

    @After
    public void after() {
        super.after();
        ClientBuilder.newClient().target("http://localhost:8080/TicTacToe").path("rest")
                .path("players").path("u1").request().delete();
    }

}
