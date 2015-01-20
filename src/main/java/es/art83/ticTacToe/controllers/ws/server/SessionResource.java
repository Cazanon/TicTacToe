package es.art83.ticTacToe.controllers.ws.server;

import java.net.URI;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;

import es.art83.ticTacToe.models.daos.DAOFactory;
import es.art83.ticTacToe.models.entities.SessionEntity;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

@Path("/sessions")
public class SessionResource {
    protected static final String PATH = "/sessions";

    protected void info(String msg) {
        LogManager.getLogger(this.getClass()).info(PATH + msg);
    }

    protected SessionEntity readSessionEntity(Integer id) {
        SessionEntity sessionEntity = DAOFactory.getFactory().getContextDAO().read(id);
        if (sessionEntity != null) {
            return sessionEntity;
        } else {
            throw new NotFoundException("Sesion (" + id + ") no existe");
        }
    }

    @Path("/hello")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String msg() {
        LogManager.getLogger(SessionResource.class).info("GET/ Hello");
        return ">>>Hola, desde RESTful";
    }

    @POST
    public Response create() {
        SessionEntity sessionEntity = new SessionEntity();
        DAOFactory.getFactory().getContextDAO().create(sessionEntity);
        this.info("POST/ session_id: " + sessionEntity.getId());
        return Response.created(URI.create(PATH + "/" + sessionEntity.getId()))
                .entity(sessionEntity.getId()).build();
    }

    @Path("/{id}/logged")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String logged(@PathParam("id") Integer id) {
        SessionEntity sessionEntity = this.readSessionEntity(id);
        Boolean result = sessionEntity.getPlayer() != null;
        this.info("GET/" + sessionEntity.getId() + "/logged: " + result);
        return Boolean.toString(result);
    }

    @Path("/{id}/state")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public TicTacToeStateModel state(@PathParam("id") Integer id) {
        SessionEntity sessionEntity = this.readSessionEntity(id);
        TicTacToeStateModel result = sessionEntity.getTicTacToeStateModel();
        this.info("GET/" + sessionEntity.getId() + "/state: " + result);
        return result;
    }

    @Path("/{id}/savedGame")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String savedGame(@PathParam("id") Integer id) {
        SessionEntity sessionEntity = this.readSessionEntity(id);
        Boolean result = sessionEntity.isSavedGame();
        LogManager.getLogger(SessionResource.class).info(
                "GET/" + sessionEntity.getId() + "/savedGame " + result);
        return Boolean.toString(result);
    }

}