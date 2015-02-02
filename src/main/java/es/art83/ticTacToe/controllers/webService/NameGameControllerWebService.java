package es.art83.ticTacToe.controllers.webService;

import java.util.ArrayList;
import java.util.List;

import es.art83.ticTacToe.controllers.NameGameController;
import es.art83.ticTacToe.models.utils.ListStringWrapper;
import es.art83.ticTacToe.webService.SessionPlayerResource;
import es.art83.ticTacToe.webService.SessionResource;
import es.art83.ticTacToe.webService.utils.WebServicesManager;

public class NameGameControllerWebService extends ControllerWebService implements NameGameController {

    private String pathSessionsIdPlayer;

    public NameGameControllerWebService(String sessionId) {
        super(sessionId);
        this.pathSessionsIdPlayer = SessionResource.PATH_SESSIONS + "/" + this.getSessionId()
                + SessionPlayerResource.PATH_PLAYER;
    }

    @Override
    public List<String> gameNames() {
        ListStringWrapper listStringWrapper = new WebServicesManager<ListStringWrapper>(
                pathSessionsIdPlayer, SessionPlayerResource.PATH_GAME_NAMES)
                .entity(ListStringWrapper.class);
        List<String> list = listStringWrapper.getListString();
        if (list == null) {
            list = new ArrayList<String>();
        }
        return list;
    }

}
