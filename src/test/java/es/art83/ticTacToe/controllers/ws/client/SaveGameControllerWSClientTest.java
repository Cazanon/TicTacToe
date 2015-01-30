package es.art83.ticTacToe.controllers.ws.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.art83.ticTacToe.controllers.LogoutController;
import es.art83.ticTacToe.controllers.ws.client.utils.TicTacToeResource;
import es.art83.ticTacToe.controllers.ws.client.utils.WebServiceClient;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.models.utils.ColorModel;

public class SaveGameControllerWSClientTest {

    private PlayerEntity playerEntity;

    private LogoutController logout;

    private PlaceControllerWSClient placeController;

    private SaveControllerWSClient saveGameController;

    @Before
    public void before() {
        ControllerFactoryWSClient factory = new ControllerFactoryWSClient();
        this.placeController = (PlaceControllerWSClient) factory.getPlaceCardController();
        this.logout = factory.getLogoutController();
        this.saveGameController = (SaveControllerWSClient) factory.getSaveGameController();
        this.playerEntity = new PlayerEntity("u", "pass");
        factory.getLoginController().register(playerEntity);
        factory.getCreateGameControler().createGame();
    }

    @Test
    public void testSaveGame() {
        this.placeController.placeCard(new CoordinateEntity(0, 0));
        this.placeController.placeCard(new CoordinateEntity(0, 1));
        this.saveGameController.saveGame("partida1");
    }


    
    public void after() {
        this.logout.logout();
        new WebServiceClient<>(TicTacToeResource.PATH_SESSIONS, this.placeController.getSessionId())
                .delete();
        new WebServiceClient<>(TicTacToeResource.PATH_PLAYERS, this.playerEntity.getUser())
                .delete();
    }

}
