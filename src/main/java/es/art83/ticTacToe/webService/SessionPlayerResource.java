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

import es.art83.ticTacToe.models.daos.DaoFactory;
import es.art83.ticTacToe.models.entities.GameEntity;
import es.art83.ticTacToe.models.entities.SessionEntity;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.models.utils.ListStringWrapper;
import es.art83.ticTacToe.models.utils.StateModel;

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
    public Response createPlayer(@PathParam("id") Integer id, PlayerEntity player) {
        PlayerEntity playerBd = DaoFactory.getFactory().getPlayerDao()
                .read(player.getUser());
        if (playerBd != null
                && playerBd.getPassword().equals(player.getPassword())) {
            SessionEntity session = this.readSessionEntity(id);
            session.setPlayer(playerBd);
            session.setState(StateModel.CLOSED_GAME);
            DaoFactory.getFactory().getSessionDao().update(session);
            this.info(id, " /POST: " + player);
            return Response.created(
                    URI.create(SessionResource.PATH_SESSIONS + id
                            + PATH_PLAYER)).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_XML)
    public void deletePlayer(@PathParam("id") Integer id) {
        SessionEntity session = this.readSessionEntity(id);
        session.setPlayer(null);
        session.setSavedGame(true);
        session.setState(StateModel.FINAL);
        GameEntity game = session.getGame();
        if (game != null) {
            Integer gameId = game.getId();
            session.setGame(null);
            DaoFactory.getFactory().getSessionDao().update(session);
            DaoFactory.getFactory().getGameDao().deleteByID(gameId);
        } else {
            DaoFactory.getFactory().getSessionDao().update(session);
        }
        this.info(id, " /DELETE");
    }

    @Path(SessionPlayerResource.PATH_GAME_NAMES)
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public ListStringWrapper nameGames(@PathParam("id") Integer id) {
        SessionEntity session = this.readSessionEntity(id);
        List<String> result = DaoFactory.getFactory().getGameDao()
                .findPlayerGameNames(session.getPlayer());
        this.info(id, PATH_GAME_NAMES + " /GET: " + result);
        return new ListStringWrapper(result);
    }

}
