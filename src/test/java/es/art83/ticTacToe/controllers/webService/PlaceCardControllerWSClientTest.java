package es.art83.ticTacToe.controllers.webService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.art83.ticTacToe.controllers.LogoutController;
import es.art83.ticTacToe.controllers.webService.ControllerFactoryWSClient;
import es.art83.ticTacToe.controllers.webService.PlaceControllerWSClient;
import es.art83.ticTacToe.controllers.webService.ShowGameControllerWSClient;
import es.art83.ticTacToe.controllers.webService.utils.TicTacToeResource;
import es.art83.ticTacToe.controllers.webService.utils.WebServiceClient;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.models.utils.ColorModel;

public class PlaceCardControllerWSClientTest {

    private PlayerEntity playerEntity;

    private LogoutController logout;

    private PlaceControllerWSClient placeController;

    private ShowGameControllerWSClient showGameController;

    @Before
    public void before() {
        ControllerFactoryWSClient factory = new ControllerFactoryWSClient();
        this.placeController = (PlaceControllerWSClient) factory.getPlaceCardController();
        this.logout = factory.getLogoutController();
        this.showGameController = (ShowGameControllerWSClient) factory.getShowGameController();
        this.playerEntity = new PlayerEntity("u", "pass");
        factory.getLoginController().register(playerEntity);
        factory.getCreateGameControler().createGame();
    }

    @Test
    public void testPlaceCard() {
        this.placeController.placeCard(new CoordinateEntity(0, 0));
        ColorModel[][] colors = this.showGameController.colors();
        assertEquals(ColorModel.X, colors[0][0]);
        assertNull(colors[1][0]);
        assertNull(colors[0][1]);
    }

    @Test
    public void testMoveCard() {
        this.placeController.placeCard(new CoordinateEntity(0, 0));
        this.placeController.placeCard(new CoordinateEntity(2, 0));
        this.placeController.placeCard(new CoordinateEntity(0, 0),new CoordinateEntity(1, 1));
        ColorModel[][] colors = this.showGameController.colors();
        assertNull(colors[0][0]);
        assertNull(colors[1][0]);
        assertNull(colors[0][1]);
        assertEquals(ColorModel.X, colors[1][1]);
    }

    @After
    public void after() {
        this.logout.logout();
        new WebServiceClient<>(TicTacToeResource.PATH_SESSIONS, this.placeController.getSessionId())
                .delete();
        new WebServiceClient<>(TicTacToeResource.PATH_PLAYERS, this.playerEntity.getUser())
                .delete();
    }

}
