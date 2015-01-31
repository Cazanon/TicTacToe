package es.art83.ticTacToe.controllers.webService;

import java.util.ArrayList;
import java.util.List;

import es.art83.ticTacToe.controllers.StartGameController;
import es.art83.ticTacToe.models.utils.ListStringWrapper;
import es.art83.ticTacToe.webService.utils.WS;
import es.art83.ticTacToe.webService.utils.WebServicesManager;

public class StartGameControllerWebService extends ControllerWebService implements StartGameController {

    private String pathSessionsIdPlayer;

    public StartGameControllerWebService(String sessionId) {
        super(sessionId);
        this.pathSessionsIdPlayer = WS.PATH_SESSIONS + "/" + this.getSessionId()
                + WS.PATH_PLAYER;
    }

    @Override
    public List<String> gameNames() {
        ListStringWrapper listStringWrapper = new WebServicesManager<ListStringWrapper>(
                pathSessionsIdPlayer, WS.PATH_GAME_NAMES)
                .entity(ListStringWrapper.class);
        List<String> list = listStringWrapper.getListString();
        if (list == null) {
            list = new ArrayList<String>();
        }
        return list;
    }

}
