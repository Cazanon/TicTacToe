package es.art83.ticTacToe.controllers.ws.server;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;

import es.art83.ticTacToe.models.daos.DAOFactory;
import es.art83.ticTacToe.models.entities.GameEntity;

/**
 * GameResource: /games<br>
 * /POST Crea un juego nuevo en la BD.<br>
 * /id /DELETE Borra un juego de la BD.<br>
 * /PUT actualiza un juego.<br>
 */
@Path("/games")
public class GameResource {

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response create(Integer sessionId) {
        Response result;
        Integer gameId= DAOFactory.getFactory().getSessionDAO().read(sessionId).getGame().getId();
        GameEntity gameEntity =  DAOFactory.getFactory().getGameDAO().read(gameId);
        DAOFactory.getFactory().getGameDAO().create(gameEntity);
        result = Response.created(URI.create("/games/" + gameEntity.getId())).build();
        LogManager.getLogger(PlayerResource.class).info("POST/games/id: " + gameEntity.getId());
        return result;
    }

    @Path("/{id}")
    @DELETE
    public void delete(@PathParam("id") Integer id) {
        DAOFactory.getFactory().getGameDAO().deleteByID(id);
        LogManager.getLogger(PlayerResource.class).info("DELETE/games/id: " + id);
    }

}
