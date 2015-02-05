package es.art83.ticTacToe.controllers.ws;

public class ControllerWebService {
    private String sessionId = null;

    private static final String PROTOCOL = "http";

    private static final String HOST = "localhost";

    private static final int PORT = 8080;

    private static final String WEB = "/TicTacToe/rest";

    //TODO habría que pasarlo por parámetro a WebServiceManager para evitar relación bidireccional
    //TODO y pasará a ser privado
    public static final String URI = PROTOCOL + "://" + HOST + ":" + PORT + WEB;

    public ControllerWebService(String sessionId) {
        assert sessionId != null;
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }

}
