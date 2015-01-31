package es.art83.ticTacToe.controllers.webService;


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
