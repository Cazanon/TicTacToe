package es.art83.ticTacToe.controllers.webService;


import es.art83.ticTacToe.controllers.LogoutController;
import es.art83.ticTacToe.controllers.webService.ControllerFactoryWebService;
import es.art83.ticTacToe.controllers.webService.PlaceControllerWebService;
import es.art83.ticTacToe.controllers.webService.SaveControllerWebService;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.webService.utils.WS;
import es.art83.ticTacToe.webService.utils.WebServicesManager;

public class SaveGameControllerWSClientTestMain {

    
    private PlayerEntity playerEntity;

    private LogoutController logout;

    private PlaceControllerWebService placeController;

    private SaveControllerWebService saveGameController;

    
    public void before() {
        ControllerFactoryWebService factory = new ControllerFactoryWebService();
        this.placeController = (PlaceControllerWebService) factory.getPlaceCardController();
        this.logout = factory.getLogoutController();
        this.saveGameController = (SaveControllerWebService) factory.getSaveGameController();
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
        //Se deben borrar los juegos del usuario
        this.logout.logout();
        new WebServicesManager<>(WS.PATH_SESSIONS, this.placeController.getSessionId())
                .delete();
        new WebServicesManager<>(WS.PATH_PLAYERS, this.playerEntity.getUser())
                .delete();
    }

    public static void main(String[] args) {
        SaveGameControllerWSClientTestMain test= new SaveGameControllerWSClientTestMain();
        test.before();
        test.testSaveGame();
        //test.after() // Falta por implementar
    }
}
