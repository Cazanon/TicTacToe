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

import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.entities.PieceEntity;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.models.utils.ColorModel;
import es.art83.ticTacToe.webService.utils.WS;
import es.art83.ticTacToe.webService.utils.WebServicesManager;

public class SessionGameResourceTest {
    private String sessionId;

    private PlayerEntity player;

    private String pathSessionsIdGame;

    private boolean createGameOk;

    @Before
    public void before() {
        // Create sessions
        WebServicesManager<String> webServiceClient = new WebServicesManager<String>(
                WS.PATH_SESSIONS);
        webServiceClient.create();
        this.sessionId = webServiceClient.entity(String.class);

        pathSessionsIdGame = WS.PATH_SESSIONS + "/" + this.sessionId
                + WS.PATH_GAME;

        // Register player
        this.player = new PlayerEntity("u", "pass");
        new WebServicesManager<>(WS.PATH_PLAYERS).create(player);
        //Login player
        new WebServicesManager<>(WS.PATH_SESSIONS, this.sessionId,
                WS.PATH_PLAYER).create(player);
        // Create game
        this.createGameOk = new WebServicesManager<>(pathSessionsIdGame).create();

    }

    @Test
    public void testCreateGameLogged() {
        assertTrue(this.createGameOk);
    }

    @Test
    public void testTurnInitial() {
        assertEquals(ColorModel.X, new WebServicesManager<ColorModel>(pathSessionsIdGame,
                WS.PATH_TURN).entity(ColorModel.class));
    }

    @Test
    public void testTurnChanged() {
        new WebServicesManager<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(0, 0));
        assertEquals(ColorModel.O, new WebServicesManager<ColorModel>(pathSessionsIdGame,
                WS.PATH_TURN).entity(ColorModel.class));
    }

    @Test
    public void testNotGameOver() {
        assertFalse(new WebServicesManager<>(pathSessionsIdGame, WS.PATH_GAME_OVER)
                .entityBoolean());
    }

    @Test
    public void testGameOver() {
        new WebServicesManager<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(0, 0));
        new WebServicesManager<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(1, 0));
        new WebServicesManager<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(0, 1));
        new WebServicesManager<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(1, 1));
        new WebServicesManager<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(0, 2));
        assertTrue(new WebServicesManager<>(pathSessionsIdGame, WS.PATH_GAME_OVER)
                .entityBoolean());
    }

    @Test
    public void testNotName() {
        assertNull(new WebServicesManager<String>(pathSessionsIdGame,
                WS.PATH_NAME).entity(String.class));
    }

   @Test
    public void testNotFullBoard() {
        new WebServicesManager<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(0, 0));
        new WebServicesManager<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(0, 1));
        new WebServicesManager<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(0, 2));
        new WebServicesManager<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(1, 0));
        new WebServicesManager<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(1, 1));
        assertFalse(new WebServicesManager<>(pathSessionsIdGame, WS.PATH_HAS_ALL_PIECES)
                .entityBoolean());
    }

    @Test
    public void testfullBoard() {
        new WebServicesManager<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(0, 0));
        new WebServicesManager<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(0, 1));
        new WebServicesManager<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(0, 2));
        new WebServicesManager<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(1, 0));
        new WebServicesManager<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(1, 1));
        new WebServicesManager<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(1, 2));
        assertTrue(new WebServicesManager<>(pathSessionsIdGame, WS.PATH_HAS_ALL_PIECES)
                .entityBoolean());
    }

    //@Test
    public void testAllPieces() {
        new WebServicesManager<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(0, 0));
        new WebServicesManager<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(0, 1));
        GenericType<List<PieceEntity>> gerericType = new GenericType<List<PieceEntity>>() {
        };
        List<PieceEntity> allPieces = new WebServicesManager<PieceEntity>(pathSessionsIdGame,
                WS.PATH_ALL_PIECES).entities(gerericType);
        assertEquals(2, allPieces.size());
        assertTrue(allPieces.contains(new PieceEntity(ColorModel.X, new CoordinateEntity(0, 0))));
        assertTrue(allPieces.contains(new PieceEntity(ColorModel.O, new CoordinateEntity(0, 1))));
    }

   // @Test
    public void testWinner() {
        new WebServicesManager<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(0, 0));
        new WebServicesManager<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(1, 0));
        new WebServicesManager<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(0, 1));
        new WebServicesManager<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(1, 1));
        new WebServicesManager<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(0, 2));
        assertEquals(ColorModel.X, new WebServicesManager<ColorModel>(pathSessionsIdGame,
                WS.PATH_WINNER).entity(ColorModel.class));
    }

    @Test
    public void testPlacePiece() {
        assertTrue(new WebServicesManager<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(0, 0)));
    }

    @Test
    public void testDeletePiece() {
        new WebServicesManager<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(0, 0));
        WebServicesManager<?> webServiceClient = new WebServicesManager<>(pathSessionsIdGame,
                WS.PATH_PIECE);
        webServiceClient.addMatrixParams("row", "0");
        webServiceClient.addMatrixParams("column", "0");
        assertTrue(webServiceClient.delete());
    }

    @After
    public void after() {
        new WebServicesManager<>(WS.PATH_SESSIONS, this.sessionId,
                WS.PATH_PLAYER).delete();
        new WebServicesManager<>(WS.PATH_SESSIONS, this.sessionId).delete();
        new WebServicesManager<>(WS.PATH_PLAYERS, this.player.getUser()).delete();
    }

}
