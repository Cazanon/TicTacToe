package es.art83.ticTacToe.controllers.ws.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.art83.ticTacToe.models.daos.DAOFactory;
import es.art83.ticTacToe.models.entities.PlayerEntity;

public class PlayerResourceTest {
    private Response response;

    private PlayerEntity playerEntity;

    protected WebTarget getWebTarget() {
        return ClientBuilder.newClient().target("http://localhost:8080/TicTacToe").path("rest")
                .path("players");
    }

    @Before
    public void before() {
        this.playerEntity = new PlayerEntity("u1", "upass");
        this.response = this.getWebTarget().request().post(Entity.xml(playerEntity));
    }

    @Test
    public void testCreateNoExist() {
        assertEquals(Response.Status.Family.SUCCESSFUL, response.getStatusInfo().getFamily());
        PlayerEntity playerEntity = DAOFactory.getFactory().getPlayerDAO()
                .read(this.playerEntity.getUser());
        assertNotNull(playerEntity);
    }
    
    @Test
    public void testCreateExist() {
        this.response = this.getWebTarget().request().post(Entity.xml(playerEntity));
        assertEquals(Response.Status.CONFLICT.getStatusCode(), response.getStatus());
    }

    @After
    public void after() {
        this.getWebTarget().path(this.playerEntity.getUser()).request().delete();
    }

}
