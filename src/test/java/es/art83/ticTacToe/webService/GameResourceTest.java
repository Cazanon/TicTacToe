package es.art83.ticTacToe.webService;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.webService.utils.WS;
import es.art83.ticTacToe.webService.utils.WebServiceHandler;

public class GameResourceTest {
    private String sessionId;

    private PlayerEntity player;

    private String pathSessionsIdGame;

    private String gameId;

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
        // Login player
        new WebServiceHandler<>(WS.PATH_SESSIONS, this.sessionId,
                WS.PATH_PLAYER).create(player);
        // Create game
        new WebServiceHandler<>(pathSessionsIdGame).create();
        // Se establece nombre de partida
        new WebServiceHandler<>(pathSessionsIdGame, WS.PATH_NAME).create("partida1");
    }

    @Test
    public void testCreateGame() {
        WebServiceHandler<String> webServiceClient = new WebServiceHandler<>(
                WS.PATH_GAMES);
        webServiceClient.addParams("sessionId", sessionId);
        assertTrue(webServiceClient.create());
        this.gameId = webServiceClient.entity(String.class);
    }

    @Test
    public void testFindGame() {
        WebServiceHandler<String> webServiceClient = new WebServiceHandler<>(
                WS.PATH_GAMES);
        webServiceClient.addParams("sessionId", sessionId);
        webServiceClient.create();

        webServiceClient = new WebServiceHandler<String>(WS.PATH_GAMES,
                WS.PATH_SEARCH);
        webServiceClient.addParams("sessionId", sessionId);
        webServiceClient.addParams("name", "partida1");
        this.gameId = webServiceClient.entity(String.class);
    }

    @After
    public void after() {
        new WebServiceHandler<>(WS.PATH_SESSIONS, this.sessionId,
                WS.PATH_PLAYER).delete();
        new WebServiceHandler<>(WS.PATH_SESSIONS, this.sessionId).delete();
        new WebServiceHandler<>(WS.PATH_GAMES, this.gameId).delete();
        new WebServiceHandler<>(WS.PATH_PLAYERS, this.player.getUser()).delete();
    }

}
