package es.art83.ticTacToe.webService;

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
import es.art83.ticTacToe.models.utils.ListStringWrapper;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

@Path(SessionResource.PATH_SESSIONS + SessionResource.PATH_ID_PARAM
        + SessionPlayerResource.PATH_PLAYER)
public class SessionPlayerResource extends SessionResource {

    public static final String PATH_PLAYER = "/player";

    public static final String PATH_GAME_NAMES = "/gameNames";

    protected void info(Integer id, String msg) {
        this.debug("/" + id + SessionPlayerResource.PATH_PLAYER + msg);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response createPlayer(@PathParam("id") Integer id, PlayerEntity playerEntity) {
        PlayerEntity playerEntityBD = DAOFactory.getFactory().getPlayerDAO()
                .read(playerEntity.getUser());
        if (playerEntityBD != null
                && playerEntityBD.getPassword().equals(playerEntity.getPassword())) {
            SessionEntity sessionEntity = this.readSessionEntity(id);
            sessionEntity.setPlayerEntity(playerEntityBD);
            sessionEntity.setTicTacToeStateModel(TicTacToeStateModel.CLOSED_GAME);
            DAOFactory.getFactory().getSessionDAO().update(sessionEntity);
            this.info(id, " /POST: " + playerEntity);
            return Response.created(
                    URI.create(SessionResource.PATH_SESSIONS + id
                            + PATH_PLAYER)).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_XML)
    public void deletePlayer(@PathParam("id") Integer id) {
        SessionEntity sessionEntity = this.readSessionEntity(id);
        sessionEntity.setPlayerEntity(null);
        sessionEntity.setSavedGame(true);
        sessionEntity.setTicTacToeStateModel(TicTacToeStateModel.FINAL);
        GameEntity gameEntity = sessionEntity.getGameEntity();
        if (gameEntity != null) {
            Integer gameId = gameEntity.getId();
            sessionEntity.setGameEntity(null);
            DAOFactory.getFactory().getSessionDAO().update(sessionEntity);
            DAOFactory.getFactory().getGameDAO().deleteByID(gameId);
        } else {
            DAOFactory.getFactory().getSessionDAO().update(sessionEntity);
        }
        this.info(id, " /DELETE");
    }

    @Path(SessionPlayerResource.PATH_GAME_NAMES)
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public ListStringWrapper nameGames(@PathParam("id") Integer id) {
        SessionEntity sessionEntity = this.readSessionEntity(id);
        List<String> result = DAOFactory.getFactory().getGameDAO()
                .findPlayerGameNames(sessionEntity.getPlayerEntity());
        this.info(id, PATH_GAME_NAMES + " /GET: " + result);
        return new ListStringWrapper(result);
    }

}
