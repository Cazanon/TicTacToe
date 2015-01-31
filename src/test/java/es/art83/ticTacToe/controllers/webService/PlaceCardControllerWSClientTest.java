package es.art83.ticTacToe.controllers.webService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.art83.ticTacToe.controllers.LogoutController;
import es.art83.ticTacToe.controllers.webService.ControllerFactoryWebService;
import es.art83.ticTacToe.controllers.webService.PlaceControllerWebService;
import es.art83.ticTacToe.controllers.webService.ShowGameControllerWebService;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.models.utils.ColorModel;
import es.art83.ticTacToe.webService.utils.WS;
import es.art83.ticTacToe.webService.utils.WebServicesManager;

public class PlaceCardControllerWSClientTest {

    private PlayerEntity playerEntity;

    private LogoutController logout;

    private PlaceControllerWebService placeController;

    private ShowGameControllerWebService showGameController;

    @Before
    public void before() {
        ControllerFactoryWebService factory = new ControllerFactoryWebService();
        this.placeController = (PlaceControllerWebService) factory.getPlaceCardController();
        this.logout = factory.getLogoutController();
        this.showGameController = (ShowGameControllerWebService) factory.getShowGameController();
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
        new WebServicesManager<>(WS.PATH_SESSIONS, this.placeController.getSessionId())
                .delete();
        new WebServicesManager<>(WS.PATH_PLAYERS, this.playerEntity.getUser())
                .delete();
    }

}
