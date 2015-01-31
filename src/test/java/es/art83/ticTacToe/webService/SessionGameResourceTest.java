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
import es.art83.ticTacToe.webService.utils.WebServiceHandler;

public class SessionGameResourceTest {
    private String sessionId;

    private PlayerEntity player;

    private String pathSessionsIdGame;

    private boolean createGameOk;

    @Before
    public void before() {
        // Create sessions
        WebServiceHandler<String> webServiceClient = new WebServiceHandler<String>(
                WS.PATH_SESSIONS);
        webServiceClient.create();
        this.sessionId = webServiceClient.entity(String.class);

        pathSessionsIdGame = WS.PATH_SESSIONS + "/" + this.sessionId
                + WS.PATH_GAME;

        // Register player
        this.player = new PlayerEntity("u", "pass");
        new WebServiceHandler<>(WS.PATH_PLAYERS).create(player);
        //Login player
        new WebServiceHandler<>(WS.PATH_SESSIONS, this.sessionId,
                WS.PATH_PLAYER).create(player);
        // Create game
        this.createGameOk = new WebServiceHandler<>(pathSessionsIdGame).create();

    }

    @Test
    public void testCreateGameLogged() {
        assertTrue(this.createGameOk);
    }

    @Test
    public void testTurnInitial() {
        assertEquals(ColorModel.X, new WebServiceHandler<ColorModel>(pathSessionsIdGame,
                WS.PATH_TURN).entity(ColorModel.class));
    }

    @Test
    public void testTurnChanged() {
        new WebServiceHandler<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(0, 0));
        assertEquals(ColorModel.O, new WebServiceHandler<ColorModel>(pathSessionsIdGame,
                WS.PATH_TURN).entity(ColorModel.class));
    }

    @Test
    public void testNotGameOver() {
        assertFalse(new WebServiceHandler<>(pathSessionsIdGame, WS.PATH_GAME_OVER)
                .entityBoolean());
    }

    @Test
    public void testGameOver() {
        new WebServiceHandler<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(0, 0));
        new WebServiceHandler<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(1, 0));
        new WebServiceHandler<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(0, 1));
        new WebServiceHandler<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(1, 1));
        new WebServiceHandler<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(0, 2));
        assertTrue(new WebServiceHandler<>(pathSessionsIdGame, WS.PATH_GAME_OVER)
                .entityBoolean());
    }

    @Test
    public void testNotName() {
        assertNull(new WebServiceHandler<String>(pathSessionsIdGame,
                WS.PATH_NAME).entity(String.class));
    }

    @Test
    public void testNotFullBoard() {
        new WebServiceHandler<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(0, 0));
        new WebServiceHandler<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(0, 1));
        new WebServiceHandler<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(0, 2));
        new WebServiceHandler<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(1, 0));
        new WebServiceHandler<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(1, 1));
        assertFalse(new WebServiceHandler<>(pathSessionsIdGame, WS.PATH_HAS_ALL_PIECES)
                .entityBoolean());
    }

    @Test
    public void testfullBoard() {
        new WebServiceHandler<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(0, 0));
        new WebServiceHandler<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(0, 1));
        new WebServiceHandler<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(0, 2));
        new WebServiceHandler<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(1, 0));
        new WebServiceHandler<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(1, 1));
        new WebServiceHandler<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(1, 2));
        assertTrue(new WebServiceHandler<>(pathSessionsIdGame, WS.PATH_HAS_ALL_PIECES)
                .entityBoolean());
    }

    @Test
    public void testAllPieces() {
        new WebServiceHandler<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(0, 0));
        new WebServiceHandler<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(0, 1));
        GenericType<List<PieceEntity>> gerericType = new GenericType<List<PieceEntity>>() {
        };
        List<PieceEntity> allPieces = new WebServiceHandler<PieceEntity>(pathSessionsIdGame,
                WS.PATH_ALL_PIECES).entities(gerericType);
        assertEquals(2, allPieces.size());
        assertTrue(allPieces.contains(new PieceEntity(ColorModel.X, new CoordinateEntity(0, 0))));
        assertTrue(allPieces.contains(new PieceEntity(ColorModel.O, new CoordinateEntity(0, 1))));
    }

    @Test
    public void testWinner() {
        new WebServiceHandler<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(0, 0));
        new WebServiceHandler<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(1, 0));
        new WebServiceHandler<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(0, 1));
        new WebServiceHandler<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(1, 1));
        new WebServiceHandler<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(0, 2));
        assertEquals(ColorModel.X, new WebServiceHandler<ColorModel>(pathSessionsIdGame,
                WS.PATH_WINNER).entity(ColorModel.class));
    }

    @Test
    public void testPlacePiece() {
        assertTrue(new WebServiceHandler<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(0, 0)));
    }

    @Test
    public void testDeletePiece() {
        new WebServiceHandler<>(pathSessionsIdGame, WS.PATH_PIECE)
                .create(new CoordinateEntity(0, 0));
        WebServiceHandler<?> webServiceClient = new WebServiceHandler<>(pathSessionsIdGame,
                WS.PATH_PIECE);
        webServiceClient.addMatrixParams("row", "0");
        webServiceClient.addMatrixParams("column", "0");
        assertTrue(webServiceClient.delete());
    }

    @After
    public void after() {
        new WebServiceHandler<>(WS.PATH_SESSIONS, this.sessionId,
                WS.PATH_PLAYER).delete();
        new WebServiceHandler<>(WS.PATH_SESSIONS, this.sessionId).delete();
        new WebServiceHandler<>(WS.PATH_PLAYERS, this.player.getUser()).delete();
    }

}
