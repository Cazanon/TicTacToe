package es.art83.ticTacToe.controllers.ws;

import es.art83.ticTacToe.controllers.LogoutController;
import es.art83.ticTacToe.controllers.ws.ControllerWsFactory;
import es.art83.ticTacToe.controllers.ws.PlacePieceControllerWs;
import es.art83.ticTacToe.controllers.ws.SaveGameControllerWs;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.ws.PlayerUris;
import es.art83.ticTacToe.ws.SessionUris;

public class SaveGameControllerWebServiceTestMain {

    private PlayerEntity playerEntity;

    private LogoutController logout;

    private PlacePieceControllerWs placeController;

    private SaveGameControllerWs saveGameController;

    public void before() {
        ControllerWsFactory factory = new ControllerWsFactory();
        this.placeController = (PlacePieceControllerWs) factory.getPlacePieceController();
        this.logout = factory.getLogoutController();
        this.saveGameController = (SaveGameControllerWs) factory.getSaveGameController();
        this.playerEntity = new PlayerEntity("u", "pass");
        factory.getLoginController().register(playerEntity);
        factory.getCreateGameControler().createGame();
    }

    public void testSaveGame() {
        this.placeController.placePiece(new CoordinateEntity(0, 0));
        this.placeController.placePiece(new CoordinateEntity(0, 1));
        this.saveGameController.saveGame("partida1");
    }

    public void after() {
        // Se deben borrar los juegos del usuario
        this.logout.logout();
        ControllerWs.buildWebServiceManager(SessionUris.PATH_SESSIONS,
                this.placeController.getSessionId()).delete();
        ControllerWs.buildWebServiceManager(PlayerUris.PATH_PLAYERS, this.playerEntity.getUser())
                .delete();
    }

    public static void main(String[] args) {
        SaveGameControllerWebServiceTestMain test = new SaveGameControllerWebServiceTestMain();
        test.before();
        test.testSaveGame();
        // test.after() // Falta por implementar
    }
}
