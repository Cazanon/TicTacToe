package es.art83.ticTacToe.controllers.webService;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.art83.ticTacToe.controllers.LogoutController;
import es.art83.ticTacToe.controllers.webService.ControllerFactoryWebService;
import es.art83.ticTacToe.controllers.webService.ShowGameControllerWebService;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.models.utils.ColorModel;
import es.art83.ticTacToe.webService.utils.WS;
import es.art83.ticTacToe.webService.utils.WebServicesManager;

public class ShowGameControllerWSClientTest {

    private ShowGameControllerWebService showGameController;

    private PlayerEntity playerEntity;

    private LogoutController logout;

    @Before
    public void before() {
        ControllerFactoryWebService factory = new ControllerFactoryWebService();
        this.showGameController = (ShowGameControllerWebService) factory.getShowGameController();
        this.logout = factory.getLogoutController();
        this.playerEntity = new PlayerEntity("u", "pass");
        factory.getLoginController().register(playerEntity);
        factory.getCreateGameControler().createGame();
    }

    @Test
    public void testGetNameGameNull() {
        assertNull(this.showGameController.getNameGame());
    }

    @Test
    public void testColors() {
        this.showGameController.colors();
    }

    @Test
    public void testIsGameOver() {
        assertFalse(this.showGameController.gameOver());
    }

    @Test
    public void testWinner() {
        assertEquals(ColorModel.O, this.showGameController.winner());
    }

    @Test
    public void testIsSavedGame() {
        assertTrue(this.showGameController.savedGame());
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
        assertTrue(this.showGameController.createdGame());
    }

    @After
    public void after() {
        this.logout.logout();
        new WebServicesManager<>(WS.PATH_SESSIONS,
                this.showGameController.getSessionId()).delete();
        new WebServicesManager<>(WS.PATH_PLAYERS, this.playerEntity.getUser())
                .delete();
    }

}
