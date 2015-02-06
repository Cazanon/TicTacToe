package es.art83.ticTacToe.controllers.ws;


public class ControllerWs {
    private String sessionId = null;

    private static final String PROTOCOL = "http";

    private static final String HOST = "localhost";

    private static final int PORT = 8080;

    private static final String WEB = "/TicTacToe/rest";

    public static final String URI = PROTOCOL + "://" + HOST + ":" + PORT + WEB;

    public ControllerWs(String sessionId) {
        assert sessionId != null;
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }
    
    protected static WsManager buildWebServiceManager(String... paths){
        return new WsManager(URI, paths);
    }

}
