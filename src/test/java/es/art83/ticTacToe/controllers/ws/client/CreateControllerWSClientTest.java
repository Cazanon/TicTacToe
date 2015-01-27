package es.art83.ticTacToe.controllers.ws.client;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.art83.ticTacToe.controllers.ws.client.ControllerFactoryWSClient;
import es.art83.ticTacToe.controllers.ws.client.LoginControllerWSClient;
import es.art83.ticTacToe.controllers.ws.client.utils.TicTacToeResource;
import es.art83.ticTacToe.controllers.ws.client.utils.WebServiceClient;
import es.art83.ticTacToe.models.entities.PlayerEntity;

public class CreateControllerWSClientTest {

    private LoginControllerWSClient login;

    private CreateControllerWSClient create;

    private PlayerEntity playerEntity;

    @Before
    public void before() {
        ControllerFactoryWSClient factory = new ControllerFactoryWSClient();
        this.login = (LoginControllerWSClient) factory.getLoginController();
        this.create=(CreateControllerWSClient) factory.getCreateGameControler();
        this.playerEntity = new PlayerEntity("u", "pass");
        this.login.register(playerEntity);
    }

    @Test
    public void testCreateGame() {
        this.create.createGame();
    }


    @After
    public void after() {
        new WebServiceClient(TicTacToeResource.PATH_SESSIONS, this.login.getSessionId()).delete();
        //Falta eliminar el juego...????
        new WebServiceClient(TicTacToeResource.PATH_PLAYERS, this.playerEntity.getUser()).delete();
    }
}
