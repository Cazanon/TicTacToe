package es.art83.ticTacToe.controllers.ws.server;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import es.art83.ticTacToe.models.daos.DAOFactory;
import es.art83.ticTacToe.models.entities.GameEntity;
import es.art83.ticTacToe.models.entities.SessionEntity;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

@Path("/sessions/{id}/player")
public class SessionPlayerResource extends SessionResource {

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response createPlayer(@PathParam("id") Integer id, PlayerEntity playerEntity) {
        PlayerEntity playerEntityBD = DAOFactory.getFactory().getPlayerDAO()
                .read(playerEntity.getUser());
        if (playerEntityBD != null
                && playerEntityBD.getPassword().equals(playerEntity.getPassword())) {
            SessionEntity sessionEntity = this.readSessionEntity(id);
            sessionEntity.setPlayer(playerEntityBD);
            sessionEntity.setTicTacToeStateModel(TicTacToeStateModel.CLOSED_GAME);
            DAOFactory.getFactory().getSessionDAO().update(sessionEntity);
            this.info("POST/" + sessionEntity.getId() + "/player");
            return Response.created(URI.create(PATH + sessionEntity.getId() + "/player")).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_XML)
    public void deletePlayer(@PathParam("id") Integer id) {
        SessionEntity sessionEntity = this.readSessionEntity(id);
        sessionEntity.setPlayer(null);
        sessionEntity.setSaved(true);
        sessionEntity.setTicTacToeStateModel(TicTacToeStateModel.FINAL);
        GameEntity gameEntity = sessionEntity.getGame();
        if (gameEntity != null) {
            Integer gameId = gameEntity.getId();
            sessionEntity.setGame(null);
            DAOFactory.getFactory().getSessionDAO().update(sessionEntity);
            DAOFactory.getFactory().getGameDAO().deleteByID(gameId);
        } else {
            DAOFactory.getFactory().getSessionDAO().update(sessionEntity);
        }
        this.info("DELETE/" + sessionEntity.getId() + "/player...");
    }

    @Path("/gameNames")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<String> nameGames(@PathParam("id") Integer id) {
        SessionEntity sessionEntity = this.readSessionEntity(id);
        List<String> result = DAOFactory.getFactory().getGameDAO()
                .findPlayerGameNames(sessionEntity.getPlayer());
        this.info("GET/" + sessionEntity.getId() + "/createdGame " + result);
        return result;
    }

}
