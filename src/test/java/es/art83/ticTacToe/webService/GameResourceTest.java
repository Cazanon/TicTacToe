package es.art83.ticTacToe.webService;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.art83.ticTacToe.controllers.ws.WebServicesManager;
import es.art83.ticTacToe.models.entities.PlayerEntity;

public class GameResourceTest extends ResourceTest {
    private String sessionId;

    private PlayerEntity player;

    private String pathSessionsIdGame;

    private String gameId;

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
        new WebServicesManager(URI, PlayerResource.PATH_PLAYERS).create(player);
        // Login player
        new WebServicesManager(URI, SessionResource.PATH_SESSIONS, this.sessionId,
                SessionPlayerResource.PATH_PLAYER).create(player);
        // Create game
        new WebServicesManager(URI, pathSessionsIdGame).create();
        // Se establece nombre de partida
        new WebServicesManager(URI, pathSessionsIdGame, SessionGameResource.PATH_NAME).create("partida1");
    }

    @Test
    public void testCreateGame() {
        WebServicesManager webServiceClient = new WebServicesManager(URI,
                GameResource.PATH_GAMES);
        webServiceClient.addParams("sessionId", sessionId);
        assertTrue(webServiceClient.create());
        this.gameId = webServiceClient.entity(String.class);
    }

    @Test
    public void testFindGame() {
        WebServicesManager webServiceClient = new WebServicesManager(URI,
                GameResource.PATH_GAMES);
        webServiceClient.addParams("sessionId", sessionId);
        webServiceClient.create();

        webServiceClient = new WebServicesManager(URI,GameResource.PATH_GAMES,
                GameResource.PATH_SEARCH);
        webServiceClient.addParams("sessionId", sessionId);
        webServiceClient.addParams("name", "partida1");
        this.gameId = webServiceClient.entity(String.class);
    }

    @After
    public void after() {
        new WebServicesManager(URI,SessionResource.PATH_SESSIONS, this.sessionId,
                SessionPlayerResource.PATH_PLAYER).delete();
        new WebServicesManager(URI,SessionResource.PATH_SESSIONS, this.sessionId).delete();
        new WebServicesManager(URI,GameResource.PATH_GAMES, this.gameId).delete();
        new WebServicesManager(URI,PlayerResource.PATH_PLAYERS, this.player.getUser()).delete();
    }

}
