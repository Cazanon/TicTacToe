package es.art83.ticTacToe.controllers.webService;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.art83.ticTacToe.controllers.LogoutController;
import es.art83.ticTacToe.controllers.webService.ControllerFactoryWebService;
import es.art83.ticTacToe.controllers.webService.PlacePieceControllerWebService;
import es.art83.ticTacToe.controllers.webService.ShowGameControllerWebService;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.entities.PieceEntity;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.webService.utils.WS;
import es.art83.ticTacToe.webService.utils.WebServicesManager;

public class PlacePieceControllerWebServiceTest {

    private PlayerEntity playerEntity;

    private LogoutController logout;

    private PlacePieceControllerWebService placeController;

    private ShowGameControllerWebService showGameController;

    @Before
    public void before() {
        ControllerFactoryWebService factory = new ControllerFactoryWebService();
        this.placeController = (PlacePieceControllerWebService) factory.getPlacePieceController();
        this.logout = factory.getLogoutController();
        this.showGameController = (ShowGameControllerWebService) factory.getShowGameController();
        this.playerEntity = new PlayerEntity("u", "pass");
        factory.getLoginController().register(playerEntity);
        factory.getCreateGameControler().createGame();
    }

    @Test
    public void testPlaceCard() {
        this.placeController.placePiece(new CoordinateEntity(0, 0));
        List<PieceEntity> pieces = this.showGameController.allPieces();
        assertEquals(1, pieces.size());
        assertEquals(new CoordinateEntity(0, 0), pieces.get(0).getCoordinateEntity());
     }

    @Test
    public void testMoveCard() {
        this.placeController.placePiece(new CoordinateEntity(0, 0));
        this.placeController.placePiece(new CoordinateEntity(2, 0));
        this.placeController.placePiece(new CoordinateEntity(0, 0), new CoordinateEntity(1, 1));
        List<PieceEntity> pieces = this.showGameController.allPieces();
        assertEquals(3,pieces.size());
    }

    @After
    public void after() {
        this.logout.logout();
        new WebServicesManager<>(WS.PATH_SESSIONS, this.placeController.getSessionId()).delete();
        new WebServicesManager<>(WS.PATH_PLAYERS, this.playerEntity.getUser()).delete();
    }

}
