package es.art83.ticTacToe.controllers.ws.client.utils;

public class TicTacToeResource {
    public static final String PROTOCOL = "http";

    public static final String HOST = "localhost";

    public static final int PORT = 8080;

    public static final String WEB = "/TicTacToe/rest";

    public static final String URI = PROTOCOL + "://" + HOST + ":" + PORT + WEB;

    public static final String PATH_SESSIONS = "/sessions";

    public static final String PATH_LOGGED = "/logged";

    public static final String PATH_PLAYERS = "/players";

    public static final String PATH_PLAYER = "/player";
}
