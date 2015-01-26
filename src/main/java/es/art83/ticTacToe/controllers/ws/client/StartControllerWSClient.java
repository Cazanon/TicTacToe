package es.art83.ticTacToe.controllers.ws.client;

import java.util.ArrayList;
import java.util.List;

import es.art83.ticTacToe.controllers.StartGameController;

public class StartControllerWSClient extends ControllerWSClient implements StartGameController {

    public StartControllerWSClient(String sessionId) {
        super(sessionId);
    }

    @Override
    public List<String> readGameNames() {
        // TODO Auto-generated method stub
        return new ArrayList<>();
    }

}
