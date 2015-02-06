package es.art83.ticTacToe.controllers.ws;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.art83.ticTacToe.controllers.LogoutController;
import es.art83.ticTacToe.controllers.ws.ControllerWsFactory;
import es.art83.ticTacToe.controllers.ws.PlacePieceControllerWs;
import es.art83.ticTacToe.controllers.ws.ShowGameControllerWs;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.entities.PieceEntity;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.webService.PlayerResource;
import es.art83.ticTacToe.webService.SessionResource;

public class PlacePieceControllerWebServiceTest {

    private PlayerEntity playerEntity;

    private LogoutController logout;

    private PlacePieceControllerWs placeController;

    private ShowGameControllerWs showGameController;

    @Before
    public void before() {
        ControllerWsFactory factory = new ControllerWsFactory();
        this.placeController = (PlacePieceControllerWs) factory.getPlacePieceController();
        this.logout = factory.getLogoutController();
        this.showGameController = (ShowGameControllerWs) factory.getShowGameController();
        this.playerEntity = new PlayerEntity("u", "pass");
        factory.getLoginController().register(playerEntity);
        factory.getCreateGameControler().createGame();
    }

    @Test
    public void testPlaceCard() {
        this.placeController.placePiece(new CoordinateEntity(0, 0));
        List<PieceEntity> pieces = this.showGameController.piecesOnBoard();
        assertEquals(1, pieces.size());
        assertEquals(new CoordinateEntity(0, 0), pieces.get(0).getCoordinate());
     }

    @Test
    public void testMoveCard() {
        this.placeController.placePiece(new CoordinateEntity(0, 0));
        this.placeController.placePiece(new CoordinateEntity(2, 0));
        this.placeController.placePiece(new CoordinateEntity(0, 0), new CoordinateEntity(1, 1));
        List<PieceEntity> pieces = this.showGameController.piecesOnBoard();
        assertEquals(3,pieces.size());
    }

    @After
    public void after() {
        this.logout.logout();
        ControllerWs.buildWebServiceManager(SessionResource.PATH_SESSIONS, this.placeController.getSessionId()).delete();
        ControllerWs.buildWebServiceManager(PlayerResource.PATH_PLAYERS, this.playerEntity.getUser()).delete();
    }

}
