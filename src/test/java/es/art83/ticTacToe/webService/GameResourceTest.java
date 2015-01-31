package es.art83.ticTacToe.webService;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.webService.utils.WS;
import es.art83.ticTacToe.webService.utils.WebServiceClient;

public class GameResourceTest {
    private String sessionId;

    private PlayerEntity player;

    private String pathSessionsIdGame;

    private String gameId;

    @Before
    public void before() {
        // Create sessions
        WebServiceClient<String> webServiceClient = new WebServiceClient<String>(
                WS.PATH_SESSIONS);
        webServiceClient.create();
        this.sessionId = webServiceClient.entity(String.class);

        pathSessionsIdGame = WS.PATH_SESSIONS + "/" + this.sessionId
                + WS.PATH_GAME;

        // Register player
        this.player = new PlayerEntity("u", "pass");
        new WebServiceClient<>(WS.PATH_PLAYERS).create(player);
        // Login player
        new WebServiceClient<>(WS.PATH_SESSIONS, this.sessionId,
                WS.PATH_PLAYER).create(player);
        // Create game
        new WebServiceClient<>(pathSessionsIdGame).create();
        // Se establece nombre de partida
        new WebServiceClient<>(pathSessionsIdGame, WS.PATH_NAME).create("partida1");
    }

    @Test
    public void testCreateGame() {
        WebServiceClient<String> webServiceClient = new WebServiceClient<>(
                WS.PATH_GAMES);
        webServiceClient.addParams("sessionId", sessionId);
        assertTrue(webServiceClient.create());
        this.gameId = webServiceClient.entity(String.class);
    }

    @Test
    public void testFindGame() {
        WebServiceClient<String> webServiceClient = new WebServiceClient<>(
                WS.PATH_GAMES);
        webServiceClient.addParams("sessionId", sessionId);
        webServiceClient.create();

        webServiceClient = new WebServiceClient<String>(WS.PATH_GAMES,
                WS.PATH_SEARCH);
        webServiceClient.addParams("sessionId", sessionId);
        webServiceClient.addParams("name", "partida1");
        this.gameId = webServiceClient.entity(String.class);
    }

    @After
    public void after() {
        new WebServiceClient<>(WS.PATH_SESSIONS, this.sessionId,
                WS.PATH_PLAYER).delete();
        new WebServiceClient<>(WS.PATH_SESSIONS, this.sessionId).delete();
        new WebServiceClient<>(WS.PATH_GAMES, this.gameId).delete();
        new WebServiceClient<>(WS.PATH_PLAYERS, this.player.getUser()).delete();
    }

}
