package es.art83.ticTacToe.webService.utils;

public class WS {
    public static final String PROTOCOL = "http";

    public static final String HOST = "localhost";

    public static final int PORT = 8080;

    public static final String WEB = "/TicTacToe/rest";

    public static final String URI = PROTOCOL + "://" + HOST + ":" + PORT + WEB;

    //
    public static final String PATH_ID_PARAM = "/{id}"; //DELETE

    // players
    public static final String PATH_PLAYERS = "/players"; //POST

    public static final String PATH_USER_PARAM = "/{user}"; //DELETE

    // games
    public static final String PATH_GAMES = "/games"; //POST

    public static final String PATH_SEARCH = "/search"; //GET

    // Sessions
    public static final String PATH_SESSIONS = "/sessions"; //POST

    public static final String PATH_LOGGED = "/logged"; //GET

    public static final String PATH_STATE = "/state"; //GET

    public static final String PATH_SAVED_GAME = "/savedGame"; //GET

    public static final String PATH_CREATED_GAME = "/createdGame"; //GET

    // sessions/id/player
    public static final String PATH_PLAYER = "/player"; //POST + DELETE

    public static final String PATH_GAME_NAMES = "/gameNames"; //GET

    // sessions/id/game
    public static final String PATH_GAME = "/game"; //POST

    public static final String PATH_NAME = "/name";  //GET + POST

    public static final String PATH_ALL_PIECES = "/allPieces"; //GET

    public static final String PATH_GAME_OVER = "/gameOver"; //GET

    public static final String PATH_WINNER = "/winner"; //GET

    public static final String PATH_TURN = "/turn"; //GET

    public static final String PATH_HAS_ALL_PIECES = "/hasAllPieces"; //GET

    public static final String PATH_VALID_SOURCE_COORDINATES = "/validSourceCoordinates"; //GET

    public static final String PATH_VALID_DESTINATION_COORDINATES = "/validDestinationCoordinates"; //GET

    public static final String PATH_PIECE = "/piece";  //POST + DELETE

    public static final String PATH_ID = "/id"; //GET

}
