package es.art83.ticTacToe.webService;

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
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.webService.utils.WS;

@Path(WS.PATH_PLAYERS)
public class PlayerResource {

    protected void debug(String msg) {
        LogManager.getLogger(this.getClass()).debug(WS.PATH_PLAYERS + msg);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response create(PlayerEntity playerEntity) {
        Response result;
        PlayerEntity playerEntityBD = DAOFactory.getFactory().getPlayerDAO()
                .read(playerEntity.getUser());
        if (playerEntityBD == null) {
            DAOFactory.getFactory().getPlayerDAO().create(playerEntity);
            result = Response.created(URI.create(WS.PATH_PLAYERS + "/" + playerEntity.getUser()))
                    .build();
            this.debug(" /POST: " + playerEntity.getUser());
        } else {
            result = Response.status(Response.Status.CONFLICT).build();
            this.debug(" /POST: CONFLICT Usuario ya existente:" + playerEntityBD.toString());
        }
        return result;
    }

    @Path(WS.PATH_USER_PARAM)
    @DELETE
    public void delete(@PathParam("user") String user) {
        DAOFactory.getFactory().getPlayerDAO().deleteByID(user);
        this.debug("/" + user + " /DELETE");
    }

}
