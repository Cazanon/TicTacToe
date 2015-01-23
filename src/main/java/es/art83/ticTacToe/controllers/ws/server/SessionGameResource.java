package es.art83.ticTacToe.controllers.ws.server;

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

import org.apache.logging.log4j.LogManager;

import es.art83.ticTacToe.models.daos.DAOFactory;
import es.art83.ticTacToe.models.entities.SessionEntity;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.entities.GameEntity;
import es.art83.ticTacToe.models.entities.PieceEntity;
import es.art83.ticTacToe.models.utils.ColorModel;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

@Path("/sessions/{id}/game")
public class SessionGameResource extends SessionResource {

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response createGame(@PathParam("id") Integer id, @QueryParam("name") String name) {
        SessionEntity sessionEntity = this.readSessionEntity(id);
        if (sessionEntity.getPlayer() != null) {
            GameEntity gameEntity;
            if (name != null) {
                gameEntity = DAOFactory.getFactory().getGameDAO()
                        .findGame(sessionEntity.getPlayer(), name);
            } else {
                gameEntity = new GameEntity(sessionEntity.getPlayer());
                DAOFactory.getFactory().getGameDAO().create(gameEntity);
            }
            sessionEntity.setGame(gameEntity);
            sessionEntity.setTicTacToeStateModel(TicTacToeStateModel.OPENED_GAME);
            sessionEntity.setSaved(true);
            DAOFactory.getFactory().getSessionDAO().update(sessionEntity);
            this.info("POST/" + sessionEntity.getId() + "/game");
            return Response.created(URI.create(PATH + sessionEntity.getId() + "/game")).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    @Path("gameOver")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String isGameOver(@PathParam("id") Integer id) {
        SessionEntity sessionEntity = this.readSessionEntity(id);
        Boolean result = sessionEntity.getGame().isGameOver();
        LogManager.getLogger(SessionResource.class).info(
                "GET/" + sessionEntity.getId() + "/gameOver " + result);
        return Boolean.toString(result);
    }

    @Path("/name")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String gameName(@PathParam("id") Integer id) {
        SessionEntity sessionEntity = this.readSessionEntity(id);
        String result = sessionEntity.getGame().getName();
        this.info("GET/" + sessionEntity.getId() + "/game/name " + result);
        return result;
    }

    @Path("/fullBoard")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String isFullBoard(@PathParam("id") Integer id) {
        SessionEntity sessionEntity = this.readSessionEntity(id);
        Boolean result = sessionEntity.getGame().isFullBoard();
        LogManager.getLogger(SessionResource.class).info(
                "GET/" + sessionEntity.getId() + "/fullBoard " + result);
        return Boolean.toString(result);
    }

    @Path("allPieces")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<PieceEntity> allPieces(@PathParam("id") Integer id) {
        SessionEntity sessionEntity = this.readSessionEntity(id);
        List<PieceEntity> result = sessionEntity.getGame().allPieces();
        this.info("GET/" + sessionEntity.getId() + "/game/allPieces " + result);
        return result;
    }

    @Path("winner")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public ColorModel gameWinner(@PathParam("id") Integer id) {
        SessionEntity sessionEntity = this.readSessionEntity(id);
        ColorModel result = sessionEntity.getGame().winner();
        this.info("GET/" + sessionEntity.getId() + "/game/name " + result);
        return result;
    }

    @Path("turn")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public ColorModel turnColor(@PathParam("id") Integer id) {
        SessionEntity sessionEntity = this.readSessionEntity(id);
        ColorModel result = sessionEntity.getGame().turnColor();
        this.info("GET/" + sessionEntity.getId() + "/game/turn " + result);
        return result;
    }

    @Path("validSourceCoordinates")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<CoordinateEntity> validSourceCoordinates(@PathParam("id") Integer id) {
        SessionEntity sessionEntity = this.readSessionEntity(id);
        List<CoordinateEntity> result = sessionEntity.getGame().validSourceCoordinates();
        this.info("GET/" + sessionEntity.getId() + "/game/validSourceCoordinates " + result);
        return result;
    }

    @Path("validDestinationCoordinates")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<CoordinateEntity> validDestinationCoordinates(@PathParam("id") Integer id) {
        SessionEntity sessionEntity = this.readSessionEntity(id);
        List<CoordinateEntity> result = sessionEntity.getGame().validDestinationCoordinates();
        this.info("GET/" + sessionEntity.getId() + "/game/validDestinationCoordinates " + result);
        return result;
    }

    @Path("/id")
    @GET
    public Integer gameId(@PathParam("id") Integer id) {
        SessionEntity sessionEntity = this.readSessionEntity(id);
        Integer result = sessionEntity.getGame().getId();
        this.info("GET/" + sessionEntity.getId() + "/game/id " + result);
        return result;
    }

    @Path("/piece")
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response createPiece(@PathParam("id") Integer id, CoordinateEntity coordinateEntity) {
        SessionEntity sessionEntity = this.readSessionEntity(id);
        sessionEntity.getGame().placeCard(coordinateEntity);
        if (sessionEntity.getGame().isGameOver()) {
            sessionEntity.setSaved(true);
            sessionEntity.setTicTacToeStateModel(TicTacToeStateModel.CLOSED_GAME);
        } else {
            sessionEntity.setSaved(false);
        }
        DAOFactory.getFactory().getSessionDAO().update(sessionEntity);
        this.info("POST/" + sessionEntity.getId() + "/piece");
        return Response.created(URI.create("/contexts/" + sessionEntity.getId() + "/piece/"))
                .build();
    }

    @Path("/piece")
    @DELETE
    @Consumes(MediaType.APPLICATION_XML)
    public void deletePiece(@PathParam("id") Integer id, @MatrixParam("row") int row,
            @MatrixParam("column") int column) {
        SessionEntity sessionEntity = this.readSessionEntity(id);
        sessionEntity.getGame().deleteCard(new CoordinateEntity(row, column));
        DAOFactory.getFactory().getSessionDAO().update(sessionEntity);
        this.info("DELETE/" + sessionEntity.getId() + "/piece");
    }

}
