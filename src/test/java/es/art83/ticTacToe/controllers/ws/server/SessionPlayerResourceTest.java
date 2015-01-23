package es.art83.ticTacToe.controllers.ws.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.art83.ticTacToe.models.entities.PlayerEntity;

public class SessionPlayerResourceTest {
    private SessionPlayerClient sessionPlayerClient;

    @Before
    public void before() {
        this.sessionPlayerClient = new SessionPlayerClient();
    }

    @Test
    public void testLoginPlayerExist() {
        assertEquals(Response.Status.Family.SUCCESSFUL, this.sessionPlayerClient.getResponse()
                .getStatusInfo().getFamily());
    }

    @Test
    public void testLoginPlayerNotExist() {
        this.sessionPlayerClient.logout();
        this.sessionPlayerClient.login(new PlayerEntity("u2", "upass"));
        assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), this.sessionPlayerClient
                .getResponse().getStatus());
    }

    @Test
    public void testLoginPlayerNotPass() {
        PlayerEntity playerEntity = new PlayerEntity(this.sessionPlayerClient.playerEntity()
                .getUser(), "no");
        this.sessionPlayerClient.logout();
        this.sessionPlayerClient.login(playerEntity);
        assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), this.sessionPlayerClient
                .getResponse().getStatus());
    }

    @Test
    public void testLogoutPlayer() {
        this.sessionPlayerClient.logout();
        fail("No implementado");
    }

    @Test
    public void testGameNames() {
        fail("No implementado");
    }

    @After
    public void after() {
        this.sessionPlayerClient.close();
    }

}
