package es.art83.ticTacToe.controllers.ws.server;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.utils.ColorModel;

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

    @Test
    public void testTurnInitial() {
        this.sessionGameClient.login();
        this.sessionGameClient.createNewGame();
        this.sessionGameClient.get("turn");
        Response response = this.sessionGameClient.getResponse();
        assertEquals(ColorModel.X, response.readEntity(ColorModel.class));
    }

    @Test
    public void testPlacePiece() {
        this.sessionGameClient.login();
        this.sessionGameClient.createNewGame();
        this.sessionGameClient.post("piece", new CoordinateEntity(0, 0));
        Response response = this.sessionGameClient.getResponse();
        assertEquals(Response.Status.Family.SUCCESSFUL, response.getStatusInfo().getFamily());
    }

    @Test
    public void testDeletePiece() {
        this.testPlacePiece();
        this.sessionGameClient.delete("piece", 0, 0);
        Response response = this.sessionGameClient.getResponse();
        assertEquals(Response.Status.Family.SUCCESSFUL, response.getStatusInfo().getFamily());
    }

    @After
    public void after() {
        this.sessionGameClient.close();
    }

}
