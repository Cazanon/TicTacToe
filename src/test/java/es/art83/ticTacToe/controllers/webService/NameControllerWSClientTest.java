package es.art83.ticTacToe.controllers.webService;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.art83.ticTacToe.controllers.webService.ControllerFactoryWSClient;
import es.art83.ticTacToe.controllers.webService.NameControllerWSClient;
import es.art83.ticTacToe.controllers.webService.utils.TicTacToeResource;
import es.art83.ticTacToe.controllers.webService.utils.WebServiceClient;
import es.art83.ticTacToe.models.entities.PlayerEntity;

public class NameControllerWSClientTest {

    private PlayerEntity playerEntity;

    private NameControllerWSClient name;

    @Before
    public void before() {
        ControllerFactoryWSClient factory = new ControllerFactoryWSClient();
        this.name = (NameControllerWSClient) factory.getNameGameController();
        this.playerEntity = new PlayerEntity("u", "pass");
        factory.getLoginController().register(playerEntity);
    }

    @Test
    public void testGameNames() {
        assertEquals(0, this.name.gameNames().size());
    }

    @After
    public void after() {
        new WebServiceClient<>(TicTacToeResource.PATH_SESSIONS, this.name.getSessionId()).delete();
        new WebServiceClient<>(TicTacToeResource.PATH_PLAYERS, this.playerEntity.getUser())
                .delete();
    }
}
