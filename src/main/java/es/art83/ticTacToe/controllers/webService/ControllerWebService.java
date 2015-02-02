package es.art83.ticTacToe.controllers.webService;

public class ControllerWebService {
    private String sessionId = null;

    public static final String PROTOCOL = "http";

    public static final String HOST = "localhost";

    public static final int PORT = 8080;

    public static final String WEB = "/TicTacToe/rest";

    public static final String URI = PROTOCOL + "://" + HOST + ":" + PORT + WEB;

    public ControllerWebService(String sessionId) {
        assert sessionId != null;
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }

}
