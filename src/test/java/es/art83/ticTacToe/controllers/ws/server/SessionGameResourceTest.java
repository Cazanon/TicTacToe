package es.art83.ticTacToe.controllers.ws.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.entities.PieceEntity;
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
    public void testNotGameOver() {
        this.sessionGameClient.login();
        this.sessionGameClient.createNewGame();
        this.sessionGameClient.get("gameOver");
        Response response = this.sessionGameClient.getResponse();
        assertFalse(Boolean.valueOf(response.readEntity(String.class)));
    }

    @Test
    public void testGameOver() {
        this.sessionGameClient.login();
        this.sessionGameClient.createNewGame();
        this.sessionGameClient.post("piece", new CoordinateEntity(0, 0));
        this.sessionGameClient.post("piece", new CoordinateEntity(1, 0));
        this.sessionGameClient.post("piece", new CoordinateEntity(0, 1));
        this.sessionGameClient.post("piece", new CoordinateEntity(2, 0));
        this.sessionGameClient.post("piece", new CoordinateEntity(0, 2));        
        this.sessionGameClient.get("gameOver");
        Response response = this.sessionGameClient.getResponse();
        assertTrue(Boolean.valueOf(response.readEntity(String.class)));
    }
    
    @Test
    public void testNotName() {
        this.sessionGameClient.login();
        this.sessionGameClient.createNewGame();
        this.sessionGameClient.get("name");
        Response response = this.sessionGameClient.getResponse();
        assertEquals("", response.readEntity(String.class));
    }

    @Test
    public void testNotFullBoard() {
        this.sessionGameClient.login();
        this.sessionGameClient.createNewGame();
        this.sessionGameClient.post("piece", new CoordinateEntity(0, 0));
        this.sessionGameClient.post("piece", new CoordinateEntity(0, 1));
        this.sessionGameClient.post("piece", new CoordinateEntity(0, 2));
        this.sessionGameClient.post("piece", new CoordinateEntity(1, 0));
        this.sessionGameClient.post("piece", new CoordinateEntity(1, 1));        
        this.sessionGameClient.get("fullBoard");
        Response response = this.sessionGameClient.getResponse();
        assertFalse(Boolean.valueOf(response.readEntity(String.class)));
    }
    
    @Test
    public void testfullBoard() {
        this.sessionGameClient.login();
        this.sessionGameClient.createNewGame();
        this.sessionGameClient.post("piece", new CoordinateEntity(0, 0));
        this.sessionGameClient.post("piece", new CoordinateEntity(0, 1));
        this.sessionGameClient.post("piece", new CoordinateEntity(0, 2));
        this.sessionGameClient.post("piece", new CoordinateEntity(1, 0));
        this.sessionGameClient.post("piece", new CoordinateEntity(1, 1));        
        this.sessionGameClient.post("piece", new CoordinateEntity(1, 2));        
        this.sessionGameClient.get("fullBoard");
        Response response = this.sessionGameClient.getResponse();
        assertTrue(Boolean.valueOf(response.readEntity(String.class)));
    }

    @Test
    public void testAllPieces() {
        this.sessionGameClient.login();
        this.sessionGameClient.createNewGame();
        this.sessionGameClient.post("piece", new CoordinateEntity(0, 0));
        this.sessionGameClient.post("piece", new CoordinateEntity(0, 1));
        this.sessionGameClient.get("allPieces");
        Response response = this.sessionGameClient.getResponse();
        List<PieceEntity> pieces = response.readEntity(new GenericType<List<PieceEntity>>() {});
        assertEquals(2, pieces.size());
        assertTrue(pieces.contains(new PieceEntity(ColorModel.X, new CoordinateEntity(0, 0))));
        assertTrue(pieces.contains(new PieceEntity(ColorModel.O,new CoordinateEntity(0, 1))));
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
