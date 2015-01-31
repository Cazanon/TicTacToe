package es.art83.ticTacToe.webService;

import java.net.URI;
import java.util.List;

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
import es.art83.ticTacToe.webService.utils.WS;

@Path(WS.PATH_GAMES)
public class GameResource {

    protected void info(String msg) {
        LogManager.getLogger(this.getClass()).info(WS.PATH_GAMES + msg);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response create(@QueryParam("sessionId") Integer sessionId) {
        Response result;
        Integer gameId = DAOFactory.getFactory().getSessionDAO().read(sessionId).getGame().getId();
        GameEntity gameEntity = DAOFactory.getFactory().getGameDAO().read(gameId);
        GameEntity gameClone = gameEntity.clone();
        DAOFactory.getFactory().getGameDAO().create(gameClone);
        result = Response.created(URI.create(WS.PATH_GAMES + "/" + gameClone.getId()))
                .entity(String.valueOf(gameClone.getId())).build();
        this.info("?sessionId=" + sessionId + " /POST: " + gameClone);
        return result;
    }

    @Path(WS.PATH_SEARCH)
    @GET
    @Consumes(MediaType.APPLICATION_XML)
    public String findGame(@QueryParam("sessionId") Integer sessionId,
            @QueryParam("name") String name) {
        PlayerEntity player = DAOFactory.getFactory().getSessionDAO().read(sessionId).getPlayer();
        GameEntity sessionGame = DAOFactory.getFactory().getSessionDAO().read(sessionId).getGame();
        List<GameEntity> games = DAOFactory.getFactory().getGameDAO().findPlayerGames(player, name);
        for (GameEntity gameEntity : games) {
            if (gameEntity.getId() == sessionGame.getId()) {
                games.remove(gameEntity);
                break;
            }
        }
        assert games.size() == 1;
        GameEntity game = games.get(0);
        this.info(WS.PATH_SEARCH + "?sessionId=" + sessionId + "&name=" + name + " /GET: " + game);
        if (game == null) {
            throw new NotFoundException();
        } else {
            return String.valueOf(game.getId());
        }

    }

    @Path(WS.PATH_ID_PARAM)
    @DELETE
    @Consumes(MediaType.APPLICATION_XML)
    public void deleteGame(@PathParam("id") Integer id) {
        DAOFactory.getFactory().getGameDAO().deleteByID(id);
        this.info("/" + id + " /DELETE");
    }

}
