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
        Response response = this.sessionGameClient.getResponse();
        assertEquals(Response.Status.Family.SUCCESSFUL, response.getStatusInfo().getFamily());
    }

    @After
    public void after() {
        this.sessionGameClient.close();
    }

}
