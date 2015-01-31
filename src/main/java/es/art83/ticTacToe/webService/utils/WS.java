package es.art83.ticTacToe.webService.utils;

public class WS {
    public static final String PROTOCOL = "http";

    public static final String HOST = "localhost";

    public static final int PORT = 8080;

    public static final String WEB = "/TicTacToe/rest";

    public static final String URI = PROTOCOL + "://" + HOST + ":" + PORT + WEB;

    //
    public static final String PATH_ID_PARAM = "/{id}";

    // players
    public static final String PATH_PLAYERS = "/players";

    public static final String PATH_USER_PARAM = "/{user}";

    // games
    public static final String PATH_GAMES = "/games";

    public static final String PATH_SEARCH = "/search";

    // Sessions
    public static final String PATH_SESSIONS = "/sessions";

    public static final String PATH_LOGGED = "/logged";

    public static final String PATH_STATE = "/state";

    public static final String PATH_SAVED_GAME = "/savedGame";

    public static final String PATH_CREATED_GAME = "/createdGame";

    // sessions/id/player
    public static final String PATH_PLAYER = "/player";

    public static final String PATH_GAME_NAMES = "/gameNames";

    // sessions/id/game
    public static final String PATH_GAME = "/game";

    public static final String PATH_NAME = "/name";

    public static final String PATH_ALL_PIECES = "/allPieces";

    public static final String PATH_GAME_OVER = "/gameOver";

    public static final String PATH_WINNER = "/winner";

    public static final String PATH_TURN = "/turn";

    public static final String PATH_HAS_ALL_PIECES = "/hasAllPieces";

    public static final String PATH_VALID_SOURCE_COORDINATES = "/validSourceCoordinates";

    public static final String PATH_VALID_DESTINATION_COORDINATES = "/validDestinationCoordinates";

    public static final String PATH_PIECE = "/piece";

    public static final String PATH_ID = "/id";

}
