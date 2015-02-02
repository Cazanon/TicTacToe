package es.art83.ticTacToe.controllers.webService;


import es.art83.ticTacToe.controllers.LogoutController;
import es.art83.ticTacToe.controllers.webService.ControllerFactoryWebService;
import es.art83.ticTacToe.controllers.webService.PlacePieceControllerWebService;
import es.art83.ticTacToe.controllers.webService.SaveGameControllerWebService;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.webService.PlayerResource;
import es.art83.ticTacToe.webService.SessionResource;
import es.art83.ticTacToe.webService.utils.WebServicesManager;

public class SaveGameControllerWebServiceTestMain {

    
    private PlayerEntity playerEntity;

    private LogoutController logout;

    private PlacePieceControllerWebService placeController;

    private SaveGameControllerWebService saveGameController;

    
    public void before() {
        ControllerFactoryWebService factory = new ControllerFactoryWebService();
        this.placeController = (PlacePieceControllerWebService) factory.getPlacePieceController();
        this.logout = factory.getLogoutController();
        this.saveGameController = (SaveGameControllerWebService) factory.getSaveGameController();
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
        new WebServicesManager<>(SessionResource.PATH_SESSIONS, this.placeController.getSessionId())
                .delete();
        new WebServicesManager<>(PlayerResource.PATH_PLAYERS, this.playerEntity.getUser())
                .delete();
    }

    public static void main(String[] args) {
        SaveGameControllerWebServiceTestMain test= new SaveGameControllerWebServiceTestMain();
        test.before();
        test.testSaveGame();
        //test.after() // Falta por implementar
    }
}
