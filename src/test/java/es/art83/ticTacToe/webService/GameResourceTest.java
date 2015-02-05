package es.art83.ticTacToe.webService;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.webService.utils.WebServicesManager;

public class GameResourceTest {
    private String sessionId;

    private PlayerEntity player;

    private String pathSessionsIdGame;

    private String gameId;

    @Before
    public void before() {
        // Create sessions
        WebServicesManager<String> webServiceClient = new WebServicesManager<String>(
                SessionResource.PATH_SESSIONS);
        webServiceClient.create();
        this.sessionId = webServiceClient.entity(String.class);

        pathSessionsIdGame = SessionResource.PATH_SESSIONS + "/" + this.sessionId
                + SessionGameResource.PATH_GAME;

        // Register player
        this.player = new PlayerEntity("u", "pass");
        new WebServicesManager<>(PlayerResource.PATH_PLAYERS).create(player);
        // Login player
        new WebServicesManager<>(SessionResource.PATH_SESSIONS, this.sessionId,
                SessionPlayerResource.PATH_PLAYER).create(player);
        // Create game
        new WebServicesManager<>(pathSessionsIdGame).create();
        // Se establece nombre de partida
        new WebServicesManager<>(pathSessionsIdGame, SessionGameResource.PATH_NAME).create("partida1");
    }

    @Test
    public void testCreateGame() {
        WebServicesManager<String> webServiceClient = new WebServicesManager<>(
                GameResource.PATH_GAMES);
        webServiceClient.addParams("sessionId", sessionId);
        assertTrue(webServiceClient.create());
        this.gameId = webServiceClient.entity(String.class);
    }

    /**
     * 
     */
    @Test
    public void testFindGame() {
//        BufferedReader t=new BufferedReader(new InputStreamReader(System.in));
//        try {
//            String d=t.readLine();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        WebServicesManager<String> webServiceClient = new WebServicesManager<>(
                GameResource.PATH_GAMES);
        webServiceClient.addParams("sessionId", sessionId);
        webServiceClient.create();

        webServiceClient = new WebServicesManager<String>(GameResource.PATH_GAMES,
                GameResource.PATH_SEARCH);
        webServiceClient.addParams("sessionId", sessionId);
        webServiceClient.addParams("name", "partida1");
        this.gameId = webServiceClient.entity(String.class);
    }

    @After
    public void after() {
        new WebServicesManager<>(SessionResource.PATH_SESSIONS, this.sessionId,
                SessionPlayerResource.PATH_PLAYER).delete();
        new WebServicesManager<>(SessionResource.PATH_SESSIONS, this.sessionId).delete();
        new WebServicesManager<>(GameResource.PATH_GAMES, this.gameId).delete();
        new WebServicesManager<>(PlayerResource.PATH_PLAYERS, this.player.getUser()).delete();
    }

}
