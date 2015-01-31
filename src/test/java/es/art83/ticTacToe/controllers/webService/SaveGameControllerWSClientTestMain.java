package es.art83.ticTacToe.controllers.webService;


import es.art83.ticTacToe.controllers.LogoutController;
import es.art83.ticTacToe.controllers.webService.ControllerFactoryWSClient;
import es.art83.ticTacToe.controllers.webService.PlaceControllerWSClient;
import es.art83.ticTacToe.controllers.webService.SaveControllerWSClient;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.webService.utils.WS;
import es.art83.ticTacToe.webService.utils.WebServiceHandler;

public class SaveGameControllerWSClientTestMain {

    
    private PlayerEntity playerEntity;

    private LogoutController logout;

    private PlaceControllerWSClient placeController;

    private SaveControllerWSClient saveGameController;

    
    public void before() {
        ControllerFactoryWSClient factory = new ControllerFactoryWSClient();
        this.placeController = (PlaceControllerWSClient) factory.getPlaceCardController();
        this.logout = factory.getLogoutController();
        this.saveGameController = (SaveControllerWSClient) factory.getSaveGameController();
        this.playerEntity = new PlayerEntity("u", "pass");
        factory.getLoginController().register(playerEntity);
        factory.getCreateGameControler().createGame();
    }

    
    public void testSaveGame() {
        this.placeController.placeCard(new CoordinateEntity(0, 0));
        this.placeController.placeCard(new CoordinateEntity(0, 1));
        this.saveGameController.saveGame("partida1");
    }


    
    public void after() {
        //Se deben borrar los juegos del usuario
        this.logout.logout();
        new WebServiceHandler<>(WS.PATH_SESSIONS, this.placeController.getSessionId())
                .delete();
        new WebServiceHandler<>(WS.PATH_PLAYERS, this.playerEntity.getUser())
                .delete();
    }

    public static void main(String[] args) {
        SaveGameControllerWSClientTestMain test= new SaveGameControllerWSClientTestMain();
        test.before();
        test.testSaveGame();
        //test.after() // Falta por implementar
    }
}
