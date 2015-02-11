package es.art83.ticTacToe.ws;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.ws.rs.core.GenericType;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.art83.ticTacToe.controllers.ws.WsManager;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.entities.PieceEntity;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.models.utils.ColorModel;
import es.art83.ticTacToe.ws.PlayerResource;
import es.art83.ticTacToe.ws.SessionGameResource;
import es.art83.ticTacToe.ws.SessionPlayerResource;
import es.art83.ticTacToe.ws.SessionResource;

public class SessionGameResourceTest extends ResourceTest {
    private String sessionId;

    private PlayerEntity player;

    private String pathSessionsIdGame;

    private boolean createGameOk;

    @Before
    public void before() {
        // Create sessions
        WsManager webServiceClient = new WsManager(URI,
                SessionResource.PATH_SESSIONS);
        webServiceClient.create();
        this.sessionId = webServiceClient.entity(String.class);

        pathSessionsIdGame = SessionResource.PATH_SESSIONS + "/" + this.sessionId
                + SessionGameResource.PATH_GAME;

        // Register player
        this.player = new PlayerEntity("u", "pass");
        new WsManager(URI,PlayerResource.PATH_PLAYERS).create(player);
        // Login player
        new WsManager(URI,SessionResource.PATH_SESSIONS, this.sessionId,
                SessionPlayerResource.PATH_PLAYER).create(player);
        // Create game
        this.createGameOk = new WsManager(URI,pathSessionsIdGame).create();

    }

    @Test
    public void testCreateGameLogged() {
        assertTrue(this.createGameOk);
    }

    @Test
    public void testTurnInitial() {
        assertEquals(ColorModel.X, new WsManager(URI,pathSessionsIdGame,
                SessionGameResource.PATH_TURN).entity(ColorModel.class));
    }

    @Test
    public void testTurnChanged() {
        new WsManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(0, 0));
        assertEquals(ColorModel.O, new WsManager(URI,pathSessionsIdGame,
                SessionGameResource.PATH_TURN).entity(ColorModel.class));
    }

    @Test
    public void testGameOver() {
        new WsManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(0, 0));
        new WsManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(1, 0));
        new WsManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(0, 1));
        new WsManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(1, 1));
        new WsManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(0, 2));
        assertEquals(ColorModel.X, new WsManager(URI,pathSessionsIdGame,
                SessionGameResource.PATH_GAME_OVER).entity(ColorModel.class));
    }

    @Test
    public void testNotName() {
        assertNull(new WsManager(URI,pathSessionsIdGame, SessionGameResource.PATH_NAME)
                .entity(String.class));
    }

    @Test
    public void testNotFullBoard() {
        new WsManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(0, 0));
        new WsManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(0, 1));
        new WsManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(0, 2));
        new WsManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(1, 0));
        new WsManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(1, 1));
        assertFalse(new WsManager(URI,pathSessionsIdGame,
                SessionGameResource.PATH_HAS_ALL_PIECES).entityBoolean());
    }

    @Test
    public void testfullBoard() {
        new WsManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(0, 0));
        new WsManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(0, 1));
        new WsManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(0, 2));
        new WsManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(1, 0));
        new WsManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(1, 1));
        new WsManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(1, 2));
        assertTrue(new WsManager(URI,pathSessionsIdGame,
                SessionGameResource.PATH_HAS_ALL_PIECES).entityBoolean());
    }

    @Test
    public void testAllPieces() {
        new WsManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(0, 0));
        new WsManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(0, 1));
        GenericType<List<PieceEntity>> gerericType = new GenericType<List<PieceEntity>>() {
        };
        List<PieceEntity> allPieces = new WsManager(URI,pathSessionsIdGame,
                SessionGameResource.PATH_ALL_PIECES).entities(gerericType);
        assertEquals(2, allPieces.size());
        assertTrue(allPieces.contains(new PieceEntity(ColorModel.X, new CoordinateEntity(0, 0))));
        assertTrue(allPieces.contains(new PieceEntity(ColorModel.O, new CoordinateEntity(0, 1))));
    }

    @Test
    public void testWinner() {
        new WsManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(0, 0));
        new WsManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(1, 0));
        new WsManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(0, 1));
        new WsManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(1, 1));
        new WsManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(0, 2));
        assertEquals(ColorModel.X, new WsManager(URI,pathSessionsIdGame,
                SessionGameResource.PATH_GAME_OVER).entity(ColorModel.class));
    }

    @Test
    public void testPlacePiece() {
        assertTrue(new WsManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(0, 0)));
    }

    @Test
    public void testDeletePiece() {
        new WsManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(0, 0));
        WsManager webServiceClient = new WsManager(URI,pathSessionsIdGame,
                SessionGameResource.PATH_PIECE);
        webServiceClient.addMatrixParams("row", "0");
        webServiceClient.addMatrixParams("column", "0");
        assertTrue(webServiceClient.delete());
    }

    @After
    public void after() {
        new WsManager(URI,SessionResource.PATH_SESSIONS, this.sessionId,
                SessionPlayerResource.PATH_PLAYER).delete();
        new WsManager(URI,SessionResource.PATH_SESSIONS, this.sessionId).delete();
        new WsManager(URI,PlayerResource.PATH_PLAYERS, this.player.getUser()).delete();
    }

}
