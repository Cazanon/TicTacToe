package es.art83.ticTacToe.controllers.ws.server;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SessionGameResourceTest {

    private SessionGameClient sessionGameClient;

    @Before
    public void before() {
        this.sessionGameClient = new SessionGameClient();
    }

    @Test
    public void testCreateGameLogged() {
        this.sessionGameClient.login();
        this.sessionGameClient.createNewGame();
        Response response = this.sessionGameClient.getResponse();
        assertEquals(Response.Status.Family.SUCCESSFUL, response.getStatusInfo().getFamily());
    }

    @Test
    public void testCreateGameNotLogged() {
        this.sessionGameClient.createNewGame();
        Response response = this.sessionGameClient.getResponse();
        assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
    }

    @After
    public void after() {
        this.sessionGameClient.close();
    }

}
