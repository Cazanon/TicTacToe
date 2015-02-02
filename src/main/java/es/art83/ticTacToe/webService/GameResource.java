package es.art83.ticTacToe.webService;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;

import es.art83.ticTacToe.models.daos.DAOFactory;
import es.art83.ticTacToe.models.entities.GameEntity;
import es.art83.ticTacToe.models.entities.PlayerEntity;

@Path(GameResource.PATH_GAMES)
public class GameResource {

    public static final String PATH_GAMES = "/games";

    public static final String PATH_SEARCH = "/search";

    private static final String PATH_ID_PARAM = "/{id}";

    protected void debug(String msg) {
        LogManager.getLogger(this.getClass()).debug(PATH_GAMES + msg);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response create(@QueryParam("sessionId") Integer sessionId) {
        Response result;
        Integer gameId = DAOFactory.getFactory().getSessionDAO().read(sessionId).getGameEntity()
                .getId();
        GameEntity gameEntity = DAOFactory.getFactory().getGameDAO().read(gameId);
        GameEntity gameClone = gameEntity.clone();
        DAOFactory.getFactory().getGameDAO().create(gameClone);
        result = Response.created(URI.create(PATH_GAMES + "/" + gameClone.getId()))
                .entity(String.valueOf(gameClone.getId())).build();
        this.debug("?sessionId=" + sessionId + " /POST: " + gameClone);
        return result;
    }

    @Path(PATH_SEARCH)
    @GET
    @Consumes(MediaType.APPLICATION_XML)
    public String findGame(@QueryParam("sessionId") Integer sessionId,
            @QueryParam("name") String name) {
        PlayerEntity player = DAOFactory.getFactory().getSessionDAO().read(sessionId)
                .getPlayerEntity();
        GameEntity game = DAOFactory.getFactory().getGameDAO().findPlayerGame(player, name);
        this.debug(PATH_SEARCH + "?sessionId=" + sessionId + "&name=" + name + " /GET: " + game);
        if (game == null) {
            throw new NotFoundException();
        } else {
            return String.valueOf(game.getId());
        }

    }

    @Path(PATH_ID_PARAM)
    @DELETE
    @Consumes(MediaType.APPLICATION_XML)
    public void deleteGame(@PathParam("id") Integer id) {
        DAOFactory.getFactory().getGameDAO().deleteByID(id);
        this.debug("/" + id + " /DELETE");
    }

}
