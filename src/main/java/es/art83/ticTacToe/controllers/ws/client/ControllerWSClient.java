package es.art83.ticTacToe.controllers.ws.client;


public class ControllerWSClient {
    private String sessionId = null;

    public ControllerWSClient(String sessionId) {
        assert sessionId != null;
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }
    

}
