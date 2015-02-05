package es.art83.ticTacToe.controllers.webService;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.art83.ticTacToe.controllers.LogoutController;
import es.art83.ticTacToe.controllers.ws.ControllerWsFactory;
import es.art83.ticTacToe.controllers.ws.ShowGameControllerWs;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.models.utils.ColorModel;
import es.art83.ticTacToe.webService.PlayerResource;
import es.art83.ticTacToe.webService.SessionResource;
import es.art83.ticTacToe.webService.utils.WebServicesManager;

public class ShowGameControllerWebServiceTest {

    private ShowGameControllerWs showGameController;

    private PlayerEntity playerEntity;

    private LogoutController logout;

    @Before
    public void before() {
        ControllerWsFactory factory = new ControllerWsFactory();
        this.showGameController = (ShowGameControllerWs) factory.getShowGameController();
        this.logout = factory.getLogoutController();
        this.playerEntity = new PlayerEntity("u", "pass");
        factory.getLoginController().register(playerEntity);
        factory.getCreateGameControler().createGame();
    }

    @Test
    public void testGetNameGameNull() {
        assertNull(this.showGameController.gameName());
    }

    @Test
    public void testIsGameOver() {
        assertNull(this.showGameController.gameOver());
    }

    @Test
    public void testTurnColor() {
        assertEquals(ColorModel.X, this.showGameController.turnColor());
    }

    @Test
    public void testHasAllPieces() {
        assertFalse(this.showGameController.hasAllPieces());
    }

    @Test
    public void testValidSourceCoordinates() {
        assertEquals(0, this.showGameController.validSourceCoordinates().size());
    }

    @Test
    public void testValidDestinationCoordinates() {
        assertEquals(9, this.showGameController.validDestinationCoordinates().size());
    }

    @Test
    public void testCreatedGame() {
        assertTrue(this.showGameController.openedGame());
    }

    @After
    public void after() {
        this.logout.logout();
        new WebServicesManager<>(SessionResource.PATH_SESSIONS,
                this.showGameController.getSessionId()).delete();
        new WebServicesManager<>(PlayerResource.PATH_PLAYERS, this.playerEntity.getUser()).delete();
    }

}
