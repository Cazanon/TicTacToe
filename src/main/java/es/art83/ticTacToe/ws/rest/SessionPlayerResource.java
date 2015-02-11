package es.art83.ticTacToe.ws.rest;

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

import org.apache.logging.log4j.LogManager;

import es.art83.ticTacToe.models.daos.DaoFactory;
import es.art83.ticTacToe.models.entities.GameEntity;
import es.art83.ticTacToe.models.entities.SessionEntity;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.models.utils.ListStringWrapper;
import es.art83.ticTacToe.models.utils.StateModel;
import es.art83.ticTacToe.ws.SessionUris;
import es.art83.ticTacToe.ws.SessionPlayerUris;

@Path(SessionUris.PATH_SESSIONS + SessionUris.PATH_ID_PARAM + SessionPlayerUris.PATH_PLAYER)
public class SessionPlayerResource {

    private void debug(Integer id, String msg) {
        LogManager.getLogger(this.getClass()).debug(
                SessionUris.PATH_SESSIONS + "/" + id + SessionPlayerUris.PATH_PLAYER + msg);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response createPlayer(@PathParam("id") Integer id, PlayerEntity player) {
        PlayerEntity playerBd = DaoFactory.getFactory().getPlayerDao().read(player.getUser());
        if (playerBd != null && playerBd.getPassword().equals(player.getPassword())) {
            SessionEntity session = SessionResource.readSession(id);
            session.setPlayer(playerBd);
            session.setState(StateModel.CLOSED_GAME);
            DaoFactory.getFactory().getSessionDao().update(session);
            this.debug(id, " /POST: " + player);
            return Response.created(URI.create(SessionUris.PATH_SESSIONS + id + SessionPlayerUris.PATH_PLAYER))
                    .build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_XML)
    public void deletePlayer(@PathParam("id") Integer id) {
        SessionEntity session = SessionResource.readSession(id);
        session.setPlayer(null);
        session.setSavedGame(true);
        session.setState(StateModel.FINAL);
        GameEntity game = session.getGame();
        if (game != null) {
            Integer gameId = game.getId();
            session.setGame(null);
            DaoFactory.getFactory().getSessionDao().update(session);
            DaoFactory.getFactory().getGameDao().deleteById(gameId);
        } else {
            DaoFactory.getFactory().getSessionDao().update(session);
        }
        this.debug(id, " /DELETE");
    }

    @Path(SessionPlayerUris.PATH_GAME_NAMES)
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public ListStringWrapper nameGames(@PathParam("id") Integer id) {
        SessionEntity session = SessionResource.readSession(id);
        List<String> result = DaoFactory.getFactory().getGameDao()
                .findPlayerGameNames(session.getPlayer());
        this.debug(id, SessionPlayerUris.PATH_GAME_NAMES + " /GET: " + result);
        return new ListStringWrapper(result);
    }

}
