package es.art83.ticTacToe.webService;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import es.art83.ticTacToe.models.daos.DaoFactory;
import es.art83.ticTacToe.models.entities.SessionEntity;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.entities.GameEntity;
import es.art83.ticTacToe.models.entities.PieceEntity;
import es.art83.ticTacToe.models.utils.ColorModel;
import es.art83.ticTacToe.models.utils.StateModel;

@Path(SessionResource.PATH_SESSIONS + SessionResource.PATH_ID_PARAM + SessionGameResource.PATH_GAME)
public class SessionGameResource extends SessionResource {

    public static final String PATH_GAME = "/game";

    public static final String PATH_NAME = "/name";

    public static final String PATH_ALL_PIECES = "/allPieces";

    public static final String PATH_GAME_OVER = "/gameOver";

    public static final String PATH_TURN = "/turn";

    public static final String PATH_HAS_ALL_PIECES = "/hasAllPieces";

    public static final String PATH_VALID_SOURCE_COORDINATES = "/validSourceCoordinates";

    public static final String PATH_VALID_DESTINATION_COORDINATES = "/validDestinationCoordinates";

    public static final String PATH_PIECE = "/piece";

    public static final String PATH_ID = "/id";

    protected void info(Integer id, String msg) {
        this.debug("/" + id + SessionGameResource.PATH_GAME + msg);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response createGame(@PathParam("id") Integer id, @QueryParam("name") String name) {
        SessionEntity session = this.readSessionEntity(id);
        if (session.getPlayer() != null) {
            GameEntity game;
            if (name == null) {
                // Se crea un juego nuevo
                game = new GameEntity(session.getPlayer());
            } else {
                // Se quiere abrir un juego existente
                game = DaoFactory.getFactory().getGameDao()
                        .findPlayerGame(session.getPlayer(), name);
                game = game.clone();
            }
            GameEntity oldGame = session.getGame();
            session.setGame(game);
            session.setState(StateModel.OPENED_GAME);
            session.setSavedGame(true);
            DaoFactory.getFactory().getSessionDao().update(session);
            // Se elimina la partida antigua de la sesión si existe
            if (oldGame != null) {
                DaoFactory.getFactory().getGameDao().deleteByID(oldGame.getId());
            }
            this.info(id, "?name=" + name + " /POST: " + session);
            return Response.created(
                    URI.create(SessionResource.PATH_SESSIONS + session.getId()
                            + SessionGameResource.PATH_GAME)).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    @Path(SessionGameResource.PATH_GAME_OVER)
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public ColorModel isGameOver(@PathParam("id") Integer id) {
        SessionEntity session = this.readSessionEntity(id);
        ColorModel result = session.getGame().gameOver();
        this.info(id, SessionGameResource.PATH_GAME_OVER + " /GET: " + result);
        return result;
    }

    @Path(SessionGameResource.PATH_NAME)
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String gameName(@PathParam("id") Integer id) {
        SessionEntity session = this.readSessionEntity(id);
        String result = session.getGame().getName();
        this.info(id, SessionGameResource.PATH_NAME + " /GET: " + result);
        return result;
    }

    @Path(SessionGameResource.PATH_NAME)
    @POST
    @Produces(MediaType.APPLICATION_XML)
    public Response setGameName(@PathParam("id") Integer id, String name) {
        SessionEntity session = this.readSessionEntity(id);
        session.getGame().setName(name);
        // DAOFactory.getFactory().getGameDAO().update(sessionEntity.getGame());
        DaoFactory.getFactory().getSessionDao().update(session);

        this.info(id, SessionGameResource.PATH_NAME + " /POST: " + session);
        return Response.created(
                URI.create(SessionResource.PATH_SESSIONS + id + SessionGameResource.PATH_GAME
                        + SessionGameResource.PATH_NAME)).build();
    }

    @Path(SessionGameResource.PATH_HAS_ALL_PIECES)
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String hasAllPieces(@PathParam("id") Integer id) {
        SessionEntity session = this.readSessionEntity(id);
        Boolean result = session.getGame().hasAllPieces();
        this.info(id, SessionGameResource.PATH_HAS_ALL_PIECES + " /GET: " + result);
        return Boolean.toString(result);
    }

    @Path(SessionGameResource.PATH_ALL_PIECES)
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<PieceEntity> allPieces(@PathParam("id") Integer id) {
        SessionEntity session = this.readSessionEntity(id);
        List<PieceEntity> result = session.getGame().allPieces();
        this.info(id, SessionGameResource.PATH_ALL_PIECES + " /GET: " + result);
        return result;
    }

    @Path(SessionGameResource.PATH_TURN)
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public ColorModel turnColor(@PathParam("id") Integer id) {
        SessionEntity session = this.readSessionEntity(id);
        ColorModel result = session.getGame().turnColor();
        this.info(id, SessionGameResource.PATH_TURN + " /GET: " + result);
        return result;
    }

    @Path(SessionGameResource.PATH_VALID_SOURCE_COORDINATES)
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<CoordinateEntity> validSourceCoordinates(@PathParam("id") Integer id) {
        SessionEntity session = this.readSessionEntity(id);
        List<CoordinateEntity> result = session.getGame().validSourceCoordinates();
        this.info(id, SessionGameResource.PATH_VALID_SOURCE_COORDINATES + " /GET: " + result);
        return result;
    }

    @Path(SessionGameResource.PATH_VALID_DESTINATION_COORDINATES)
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<CoordinateEntity> validDestinationCoordinates(@PathParam("id") Integer id) {
        SessionEntity session = this.readSessionEntity(id);
        List<CoordinateEntity> result = session.getGame().validDestinationCoordinates();
        this.info(id, SessionGameResource.PATH_VALID_DESTINATION_COORDINATES + " /GET: " + result);
        return result;
    }

    @Path(SessionGameResource.PATH_ID)
    @GET
    public Integer gameId(@PathParam("id") Integer id) {
        SessionEntity session = this.readSessionEntity(id);
        Integer result = session.getGame().getId();
        this.info(id, SessionGameResource.PATH_ID + " /GET: " + result);
        return result;
    }

    @Path(SessionGameResource.PATH_PIECE)
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response createPiece(@PathParam("id") Integer id, CoordinateEntity coordinateEntity) {
        SessionEntity session = this.readSessionEntity(id);
        session.getGame().placePiece(coordinateEntity);
        if (session.getGame().gameOver() != null) {
            session.setState(StateModel.CLOSED_GAME);
        }
        session.setSavedGame(false);

        DaoFactory.getFactory().getSessionDao().update(session);
        this.info(id, SessionGameResource.PATH_PIECE + " /POST: " + coordinateEntity);
        return Response.created(
                URI.create(SessionResource.PATH_SESSIONS + "/" + session.getId()
                        + SessionGameResource.PATH_GAME + SessionGameResource.PATH_PIECE)).build();
    }

    @Path(SessionGameResource.PATH_PIECE)
    @DELETE
    @Consumes(MediaType.APPLICATION_XML)
    public void deletePiece(@PathParam("id") Integer id, @MatrixParam("row") int row,
            @MatrixParam("column") int column) {
        SessionEntity session = this.readSessionEntity(id);
        CoordinateEntity coordinate = new CoordinateEntity(row, column);
        PieceEntity piece = session.getGame().deletePiece(coordinate);
        DaoFactory.getFactory().getSessionDao().update(session);
        // Falta elimiar la pieza de la tabla, se van acumulando
        DaoFactory.getFactory().getPieceDao().deleteByID(piece.getId());
        this.info(id, SessionGameResource.PATH_PIECE + ";" + row + ";" + column + " /DELETE");
    }

}
