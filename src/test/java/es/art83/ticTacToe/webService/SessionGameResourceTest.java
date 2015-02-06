package es.art83.ticTacToe.webService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.ws.rs.core.GenericType;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.art83.ticTacToe.controllers.ws.WebServicesManager;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.entities.PieceEntity;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.models.utils.ColorModel;

public class SessionGameResourceTest extends ResourceTest {
    private String sessionId;

    private PlayerEntity player;

    private String pathSessionsIdGame;

    private boolean createGameOk;

    @Before
    public void before() {
        // Create sessions
        WebServicesManager webServiceClient = new WebServicesManager(URI,
                SessionResource.PATH_SESSIONS);
        webServiceClient.create();
        this.sessionId = webServiceClient.entity(String.class);

        pathSessionsIdGame = SessionResource.PATH_SESSIONS + "/" + this.sessionId
                + SessionGameResource.PATH_GAME;

        // Register player
        this.player = new PlayerEntity("u", "pass");
        new WebServicesManager(URI,PlayerResource.PATH_PLAYERS).create(player);
        // Login player
        new WebServicesManager(URI,SessionResource.PATH_SESSIONS, this.sessionId,
                SessionPlayerResource.PATH_PLAYER).create(player);
        // Create game
        this.createGameOk = new WebServicesManager(URI,pathSessionsIdGame).create();

    }

    @Test
    public void testCreateGameLogged() {
        assertTrue(this.createGameOk);
    }

    @Test
    public void testTurnInitial() {
        assertEquals(ColorModel.X, new WebServicesManager(URI,pathSessionsIdGame,
                SessionGameResource.PATH_TURN).entity(ColorModel.class));
    }

    @Test
    public void testTurnChanged() {
        new WebServicesManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(0, 0));
        assertEquals(ColorModel.O, new WebServicesManager(URI,pathSessionsIdGame,
                SessionGameResource.PATH_TURN).entity(ColorModel.class));
    }

    @Test
    public void testGameOver() {
        new WebServicesManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(0, 0));
        new WebServicesManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(1, 0));
        new WebServicesManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(0, 1));
        new WebServicesManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(1, 1));
        new WebServicesManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(0, 2));
        assertEquals(ColorModel.X, new WebServicesManager(URI,pathSessionsIdGame,
                SessionGameResource.PATH_GAME_OVER).entity(ColorModel.class));
    }

    @Test
    public void testNotName() {
        assertNull(new WebServicesManager(URI,pathSessionsIdGame, SessionGameResource.PATH_NAME)
                .entity(String.class));
    }

    @Test
    public void testNotFullBoard() {
        new WebServicesManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(0, 0));
        new WebServicesManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(0, 1));
        new WebServicesManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(0, 2));
        new WebServicesManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(1, 0));
        new WebServicesManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(1, 1));
        assertFalse(new WebServicesManager(URI,pathSessionsIdGame,
                SessionGameResource.PATH_HAS_ALL_PIECES).entityBoolean());
    }

    @Test
    public void testfullBoard() {
        new WebServicesManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(0, 0));
        new WebServicesManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(0, 1));
        new WebServicesManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(0, 2));
        new WebServicesManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(1, 0));
        new WebServicesManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(1, 1));
        new WebServicesManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(1, 2));
        assertTrue(new WebServicesManager(URI,pathSessionsIdGame,
                SessionGameResource.PATH_HAS_ALL_PIECES).entityBoolean());
    }

    @Test
    public void testAllPieces() {
        new WebServicesManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(0, 0));
        new WebServicesManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(0, 1));
        GenericType<List<PieceEntity>> gerericType = new GenericType<List<PieceEntity>>() {
        };
        List<PieceEntity> allPieces = new WebServicesManager(URI,pathSessionsIdGame,
                SessionGameResource.PATH_ALL_PIECES).entities(gerericType);
        assertEquals(2, allPieces.size());
        assertTrue(allPieces.contains(new PieceEntity(ColorModel.X, new CoordinateEntity(0, 0))));
        assertTrue(allPieces.contains(new PieceEntity(ColorModel.O, new CoordinateEntity(0, 1))));
    }

    @Test
    public void testWinner() {
        new WebServicesManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(0, 0));
        new WebServicesManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(1, 0));
        new WebServicesManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(0, 1));
        new WebServicesManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(1, 1));
        new WebServicesManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(0, 2));
        assertEquals(ColorModel.X, new WebServicesManager(URI,pathSessionsIdGame,
                SessionGameResource.PATH_GAME_OVER).entity(ColorModel.class));
    }

    @Test
    public void testPlacePiece() {
        assertTrue(new WebServicesManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(0, 0)));
    }

    @Test
    public void testDeletePiece() {
        new WebServicesManager(URI,pathSessionsIdGame, SessionGameResource.PATH_PIECE)
                .create(new CoordinateEntity(0, 0));
        WebServicesManager webServiceClient = new WebServicesManager(URI,pathSessionsIdGame,
                SessionGameResource.PATH_PIECE);
        webServiceClient.addMatrixParams("row", "0");
        webServiceClient.addMatrixParams("column", "0");
        assertTrue(webServiceClient.delete());
    }

    @After
    public void after() {
        new WebServicesManager(URI,SessionResource.PATH_SESSIONS, this.sessionId,
                SessionPlayerResource.PATH_PLAYER).delete();
        new WebServicesManager(URI,SessionResource.PATH_SESSIONS, this.sessionId).delete();
        new WebServicesManager(URI,PlayerResource.PATH_PLAYERS, this.player.getUser()).delete();
    }

}
