package es.art83.ticTacToe.controllers.ws;


public class ControllerWebService {
    private String sessionId = null;

    private static final String PROTOCOL = "http";

    private static final String HOST = "localhost";

    private static final int PORT = 8080;

    private static final String WEB = "/TicTacToe/rest";

    public static final String URI = PROTOCOL + "://" + HOST + ":" + PORT + WEB;

    public ControllerWebService(String sessionId) {
        assert sessionId != null;
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }
    
    protected static WebServicesManager buildWebServiceManager(String... paths){
        return new WebServicesManager(URI, paths);
    }

}
