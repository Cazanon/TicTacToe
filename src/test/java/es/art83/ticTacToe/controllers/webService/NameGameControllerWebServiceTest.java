package es.art83.ticTacToe.controllers.webService;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.art83.ticTacToe.controllers.webService.ControllerFactoryWebService;
import es.art83.ticTacToe.controllers.webService.NameGameControllerWebService;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.webService.utils.WS;
import es.art83.ticTacToe.webService.utils.WebServicesManager;

public class NameGameControllerWebServiceTest {

    private PlayerEntity playerEntity;

    private NameGameControllerWebService name;

    @Before
    public void before() {
        ControllerFactoryWebService factory = new ControllerFactoryWebService();
        this.name = (NameGameControllerWebService) factory.getNameGameController();
        this.playerEntity = new PlayerEntity("u", "pass");
        factory.getLoginController().register(playerEntity);
    }

    @Test
    public void testGameNames() {
        assertEquals(0, this.name.gameNames().size());
    }

    @After
    public void after() {
        new WebServicesManager<>(WS.PATH_SESSIONS, this.name.getSessionId()).delete();
        new WebServicesManager<>(WS.PATH_PLAYERS, this.playerEntity.getUser())
                .delete();
    }
}
