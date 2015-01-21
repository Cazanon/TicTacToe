package es.art83.ticTacToe.models.daos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
        System.out.println("before...");
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
    
    public void testCreateNoExist2() {
        assertEquals(Response.Status.Family.SUCCESSFUL, response.getStatusInfo().getFamily());
/*        PlayerEntity playerEntity = DAOFactory.getFactory().getPlayerDAO()
                .read(this.playerEntity.getUser());
        assertNotNull(playerEntity);
*/    }

    @After
    public void after() {
        System.out.println("after...");
        DAOFactory.getFactory().getPlayerDAO().deleteByID(this.playerEntity.getUser());
    }

}
