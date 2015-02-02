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

import es.art83.ticTacToe.models.daos.DAOFactory;
import es.art83.ticTacToe.models.entities.SessionEntity;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.entities.GameEntity;
import es.art83.ticTacToe.models.entities.PieceEntity;
import es.art83.ticTacToe.models.utils.ColorModel;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

@Path(SessionResource.PATH_SESSIONS + SessionResource.PATH_ID_PARAM + SessionGameResource.PATH_GAME)
public class SessionGameResource extends SessionResource {

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

    protected void info(Integer id, String msg) {
        this.debug("/" + id + SessionGameResource.PATH_GAME + msg);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response createGame(@PathParam("id") Integer id, @QueryParam("name") String name) {
        SessionEntity sessionEntity = this.readSessionEntity(id);
        if (sessionEntity.getPlayerEntity() != null) {
            GameEntity gameEntity;
            if (name != null) {
                // Solo puede haber uno
                gameEntity = DAOFactory.getFactory().getGameDAO()
                        .findPlayerGames(sessionEntity.getPlayerEntity(), name).get(0);
                gameEntity = gameEntity.clone();
                // DAOFactory.getFactory().getGameDAO().create(gameEntity.clone());
            } else {
                gameEntity = new GameEntity(sessionEntity.getPlayerEntity());
                // DAOFactory.getFactory().getGameDAO().create(gameEntity);
            }
            sessionEntity.setGameEntity(gameEntity);
            sessionEntity.setTicTacToeStateModel(TicTacToeStateModel.OPENED_GAME);
            sessionEntity.setSavedGame(true);
            DAOFactory.getFactory().getSessionDAO().update(sessionEntity);
            this.info(id, "?name=" + name + " /POST: " + sessionEntity);
            return Response.created(
                    URI.create(SessionResource.PATH_SESSIONS + sessionEntity.getId() + SessionGameResource.PATH_GAME)).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    @Path(SessionGameResource.PATH_GAME_OVER)
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String isGameOver(@PathParam("id") Integer id) {
        SessionEntity sessionEntity = this.readSessionEntity(id);
        Boolean result = sessionEntity.getGameEntity().gameOver();
        this.info(id, SessionGameResource.PATH_GAME_OVER + " /GET: " + result);
        return Boolean.toString(result);
    }

    @Path(SessionGameResource.PATH_NAME)
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String gameName(@PathParam("id") Integer id) {
        SessionEntity sessionEntity = this.readSessionEntity(id);
        String result = sessionEntity.getGameEntity().getName();
        this.info(id, SessionGameResource.PATH_NAME + " /GET: " + result);
        return result;
    }

    @Path(SessionGameResource.PATH_NAME)
    @POST
    @Produces(MediaType.APPLICATION_XML)
    public Response setGameName(@PathParam("id") Integer id, String name) {
        SessionEntity sessionEntity = this.readSessionEntity(id);
        sessionEntity.getGameEntity().setName(name);
        //DAOFactory.getFactory().getGameDAO().update(sessionEntity.getGame());
        DAOFactory.getFactory().getSessionDAO().update(sessionEntity);

        this.info(id, SessionGameResource.PATH_NAME + " /POST: " + sessionEntity);
        return Response.created(URI.create(SessionResource.PATH_SESSIONS + id + SessionGameResource.PATH_GAME + SessionGameResource.PATH_NAME))
                .build();
    }

    @Path(SessionGameResource.PATH_HAS_ALL_PIECES)
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String hasAllPieces(@PathParam("id") Integer id) {
        SessionEntity sessionEntity = this.readSessionEntity(id);
        Boolean result = sessionEntity.getGameEntity().hasAllPieces();
        this.info(id, SessionGameResource.PATH_HAS_ALL_PIECES + " /GET: " + result);
        return Boolean.toString(result);
    }

    @Path(SessionGameResource.PATH_ALL_PIECES)
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<PieceEntity> allPieces(@PathParam("id") Integer id) {
        SessionEntity sessionEntity = this.readSessionEntity(id);
        List<PieceEntity> result = sessionEntity.getGameEntity().allPieces();
        this.info(id, SessionGameResource.PATH_ALL_PIECES + " /GET: " + result);
        return result;
    }

    @Path(SessionGameResource.PATH_WINNER)
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public ColorModel gameWinner(@PathParam("id") Integer id) {
        SessionEntity sessionEntity = this.readSessionEntity(id);
        ColorModel result = sessionEntity.getGameEntity().winner();
        this.info(id, SessionGameResource.PATH_WINNER + " /GET: " + result);
        return result;
    }

    @Path(SessionGameResource.PATH_TURN)
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public ColorModel turnColor(@PathParam("id") Integer id) {
        SessionEntity sessionEntity = this.readSessionEntity(id);
        ColorModel result = sessionEntity.getGameEntity().turnColor();
        this.info(id, SessionGameResource.PATH_TURN + " /GET: " + result);
        return result;
    }

    @Path(SessionGameResource.PATH_VALID_SOURCE_COORDINATES)
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<CoordinateEntity> validSourceCoordinates(@PathParam("id") Integer id) {
        SessionEntity sessionEntity = this.readSessionEntity(id);
        List<CoordinateEntity> result = sessionEntity.getGameEntity().validSourceCoordinates();
        this.info(id, SessionGameResource.PATH_VALID_SOURCE_COORDINATES + " /GET: " + result);
        return result;
    }

    @Path(SessionGameResource.PATH_VALID_DESTINATION_COORDINATES)
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<CoordinateEntity> validDestinationCoordinates(@PathParam("id") Integer id) {
        SessionEntity sessionEntity = this.readSessionEntity(id);
        List<CoordinateEntity> result = sessionEntity.getGameEntity().validDestinationCoordinates();
        this.info(id, SessionGameResource.PATH_VALID_DESTINATION_COORDINATES + " /GET: " + result);
        return result;
    }

    @Path(SessionGameResource.PATH_ID)
    @GET
    public Integer gameId(@PathParam("id") Integer id) {
        SessionEntity sessionEntity = this.readSessionEntity(id);
        Integer result = sessionEntity.getGameEntity().getId();
        this.info(id, SessionGameResource.PATH_ID + " /GET: " + result);
        return result;
    }

    @Path(SessionGameResource.PATH_PIECE)
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response createPiece(@PathParam("id") Integer id, CoordinateEntity coordinateEntity) {
        SessionEntity sessionEntity = this.readSessionEntity(id);
        sessionEntity.getGameEntity().placePiece(coordinateEntity);
        if (sessionEntity.getGameEntity().gameOver()) {
            sessionEntity.setSavedGame(true);
            sessionEntity.setTicTacToeStateModel(TicTacToeStateModel.CLOSED_GAME);
        } else {
            sessionEntity.setSavedGame(false);
        }
        DAOFactory.getFactory().getSessionDAO().update(sessionEntity);
        this.info(id, SessionGameResource.PATH_PIECE + " /POST: " + coordinateEntity);
        return Response.created(
                URI.create(SessionResource.PATH_SESSIONS + "/" + sessionEntity.getId() + SessionGameResource.PATH_GAME
                        + SessionGameResource.PATH_PIECE)).build();
    }

    @Path(SessionGameResource.PATH_PIECE)
    @DELETE
    @Consumes(MediaType.APPLICATION_XML)
    public void deletePiece(@PathParam("id") Integer id, @MatrixParam("row") int row,
            @MatrixParam("column") int column) {
        SessionEntity sessionEntity = this.readSessionEntity(id);
        CoordinateEntity coordinate = new CoordinateEntity(row, column);
        PieceEntity piece = sessionEntity.getGameEntity().deletePiece(coordinate);
        DAOFactory.getFactory().getSessionDAO().update(sessionEntity);
        // Falta elimiar la pieza de la tabla, se van acumulando
        DAOFactory.getFactory().getPieceDAO().deleteByID(piece.getId());
        this.info(id, SessionGameResource.PATH_PIECE + ";" + row + ";" + column + " /DELETE");
    }

}
