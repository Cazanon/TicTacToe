package es.art83.ticTacToe.controllers.ws.server;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.art83.ticTacToe.controllers.ws.client.utils.TicTacToeResource;
import es.art83.ticTacToe.controllers.ws.client.utils.WebServiceClient;
import es.art83.ticTacToe.models.entities.PlayerEntity;

public class GameResourceTest {
    private String sessionId;

    private PlayerEntity player;

    private String pathSessionsIdGame;

    private String gameId;

    @Before
    public void before() {
        // Create sessions
        WebServiceClient<String> webServiceClient = new WebServiceClient<String>(
                TicTacToeResource.PATH_SESSIONS);
        webServiceClient.create();
        this.sessionId = webServiceClient.entity(String.class);

        pathSessionsIdGame = TicTacToeResource.PATH_SESSIONS + "/" + this.sessionId
                + TicTacToeResource.PATH_GAME;

        // Register player
        this.player = new PlayerEntity("u", "pass");
        new WebServiceClient<>(TicTacToeResource.PATH_PLAYERS).create(player);
        // Login player
        new WebServiceClient<>(TicTacToeResource.PATH_SESSIONS, this.sessionId,
                TicTacToeResource.PATH_PLAYER).create(player);
        // Create game
        new WebServiceClient<>(pathSessionsIdGame).create();

    }

    @Test
    public void testCreateGame() {
        WebServiceClient<String> webServiceClient = new WebServiceClient<>(
                TicTacToeResource.PATH_GAMES);
        webServiceClient.addParams("sessionId", sessionId);
        assertTrue(webServiceClient.create());
        this.gameId = webServiceClient.entity(String.class);
    }

    @After
    public void after() {
        new WebServiceClient<>(TicTacToeResource.PATH_SESSIONS, this.sessionId,
                TicTacToeResource.PATH_PLAYER).delete();
        new WebServiceClient<>(TicTacToeResource.PATH_SESSIONS, this.sessionId).delete();
        new WebServiceClient<>(TicTacToeResource.PATH_GAMES, this.gameId).delete();
        new WebServiceClient<>(TicTacToeResource.PATH_PLAYERS, this.player.getUser()).delete();
    }

}
