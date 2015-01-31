package es.art83.ticTacToe.controllers.webService;


public class ControllerWebService {
    private String sessionId = null;

    public ControllerWebService(String sessionId) {
        assert sessionId != null;
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }
    

}
