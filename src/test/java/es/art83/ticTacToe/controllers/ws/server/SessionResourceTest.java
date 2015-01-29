package es.art83.ticTacToe.controllers.ws.server;

import static org.junit.Assert.*;

import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.art83.ticTacToe.controllers.ws.client.utils.TicTacToeResource;
import es.art83.ticTacToe.controllers.ws.client.utils.WebServiceClient;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

public class SessionResourceTest {

    public boolean login(PlayerEntity playerEntity) {
        return new WebServiceClient<>(pathSessionsId, TicTacToeResource.PATH_PLAYER)
                .create(playerEntity);
    }

    private SessionClient sessionClient;
    private String sessionId;

    @Before
    public void createSession() {
        this.sessionClient = new SessionClient();
    }

    @Test
    public void testCreate() {
        WebServiceClient<String> webService = new WebServiceClient<>(TicTacToeResource.PATH_SESSIONS);
        assertTrue(webService.create());
        this.sessionId= webService.entity(String.class);
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
