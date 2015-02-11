package es.art83.ticTacToe.ws;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.art83.ticTacToe.controllers.ws.WsManager;
import es.art83.ticTacToe.models.entities.PlayerEntity;

public class GameResourceTest extends ResourceTest {
    private String sessionId;

    private PlayerEntity player;

    private String pathSessionsIdGame;

    private String gameId;

    @Before
    public void before() {
        // Create sessions
        WsManager webServiceClient = new WsManager(URI,
                SessionUris.PATH_SESSIONS);
        webServiceClient.create();
        this.sessionId = webServiceClient.entity(String.class);

        pathSessionsIdGame = SessionUris.PATH_SESSIONS + "/" + this.sessionId
                + SessionGameUris.PATH_GAME;

        // Register player
        this.player = new PlayerEntity("u", "pass");
        new WsManager(URI, PlayerUris.PATH_PLAYERS).create(player);
        // Login player
        new WsManager(URI, SessionUris.PATH_SESSIONS, this.sessionId,
                SessionPlayerUris.PATH_PLAYER).create(player);
        // Create game
        new WsManager(URI, pathSessionsIdGame).create();
        // Se establece nombre de partida
        new WsManager(URI, pathSessionsIdGame, SessionGameUris.PATH_NAME).create("partida1");
    }

    @Test
    public void testCreateGame() {
        WsManager webServiceClient = new WsManager(URI,
                GameUris.PATH_GAMES);
        webServiceClient.addParams("sessionId", sessionId);
        assertTrue(webServiceClient.create());
        this.gameId = webServiceClient.entity(String.class);
    }

    @Test
    public void testFindGame() {
        WsManager webServiceClient = new WsManager(URI,
                GameUris.PATH_GAMES);
        webServiceClient.addParams("sessionId", sessionId);
        webServiceClient.create();

        webServiceClient = new WsManager(URI,GameUris.PATH_GAMES,
                GameUris.PATH_SEARCH);
        webServiceClient.addParams("sessionId", sessionId);
        webServiceClient.addParams("name", "partida1");
        this.gameId = webServiceClient.entity(String.class);
    }

    @After
    public void after() {
        new WsManager(URI,SessionUris.PATH_SESSIONS, this.sessionId,
                SessionPlayerUris.PATH_PLAYER).delete();
        new WsManager(URI,SessionUris.PATH_SESSIONS, this.sessionId).delete();
        new WsManager(URI,GameUris.PATH_GAMES, this.gameId).delete();
        new WsManager(URI,PlayerUris.PATH_PLAYERS, this.player.getUser()).delete();
    }

}
