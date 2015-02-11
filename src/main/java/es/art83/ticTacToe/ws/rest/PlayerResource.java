package es.art83.ticTacToe.ws.rest;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;

import es.art83.ticTacToe.models.daos.DaoFactory;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.ws.PlayerUris;

@Path(PlayerUris.PATH_PLAYERS)
public class PlayerResource {

    private void debug(String msg) {
        LogManager.getLogger(this.getClass()).debug(PlayerUris.PATH_PLAYERS + msg);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response create(PlayerEntity player) {
        Response result;
        PlayerEntity playerBd = DaoFactory.getFactory().getPlayerDao()
                .read(player.getUser());
        if (playerBd == null) {
            DaoFactory.getFactory().getPlayerDao().create(player);
            result = Response.created(URI.create(PlayerUris.PATH_PLAYERS + "/" + player.getUser()))
                    .build();
            this.debug(" /POST: " + player.getUser());
        } else {
            result = Response.status(Response.Status.CONFLICT).build();
            this.debug(" /POST: CONFLICT Usuario ya existente:" + playerBd.toString());
        }
        return result;
    }

    @Path(PlayerUris.PATH_USER_PARAM)
    @DELETE
    public void delete(@PathParam("user") String user) {
        DaoFactory.getFactory().getPlayerDao().deleteById(user);
        this.debug("/" + user + " /DELETE");
    }

}
