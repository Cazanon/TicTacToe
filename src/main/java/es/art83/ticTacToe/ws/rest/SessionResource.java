package es.art83.ticTacToe.ws.rest;

import java.net.URI;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;

import es.art83.ticTacToe.models.daos.DaoFactory;
import es.art83.ticTacToe.models.daos.SessionDao;
import es.art83.ticTacToe.models.entities.SessionEntity;
import es.art83.ticTacToe.models.utils.StateModel;

import es.art83.ticTacToe.ws.SessionUris;

@Path(SessionUris.PATH_SESSIONS)
public class SessionResource {

    private void debug(String msg) {
        LogManager.getLogger(this.getClass()).debug(SessionUris.PATH_SESSIONS + msg);
    }

    static SessionEntity readSession(Integer id) {
        SessionEntity session = DaoFactory.getFactory().getSessionDao().read(id);
        if (session != null) {
            return session;
        } else {
            throw new NotFoundException("Sesion (" + id + ") no existe");
        }
    }

    @POST
    public Response create() {
        SessionEntity session = new SessionEntity();
        DaoFactory.getFactory().getSessionDao().create(session);
        this.debug(" POST/ sessionId: " + session.getId());
        return Response.created(URI.create(SessionUris.PATH_SESSIONS + "/" + session.getId()))
                .entity(String.valueOf(session.getId())).build();
    }

    @Path(SessionUris.PATH_ID_PARAM + SessionUris.PATH_LOGGED)
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String logged(@PathParam("id") Integer id) {
        SessionEntity session = readSession(id);
        Boolean result = session.getPlayer() != null;
        this.debug("/" + session.getId() + SessionUris.PATH_LOGGED + " /GET: " + result);
        return Boolean.toString(result);
    }

    @Path(SessionUris.PATH_ID_PARAM + SessionUris.PATH_STATE)
    @GET
    public StateModel state(@PathParam("id") Integer id) {
        SessionEntity session = readSession(id);
        StateModel result = session.getState();
        this.debug("/" + session.getId() + SessionUris.PATH_STATE + " /GET: " + result);
        return result;
    }

    @Path(SessionUris.PATH_ID_PARAM + SessionUris.PATH_SAVED_GAME)
    @GET
    public String savedGame(@PathParam("id") Integer id) {
        SessionEntity session = readSession(id);
        Boolean result = session.isSavedGame();
        this.debug(session.getId() + SessionUris.PATH_SAVED_GAME + " /GET: " + result);
        return Boolean.toString(result);
    }

    @Path(SessionUris.PATH_ID_PARAM)
    @DELETE
    public void delete(@PathParam("id") Integer id) {
        SessionDao sessionDao = DaoFactory.getFactory().getSessionDao();
        SessionEntity session = sessionDao.read(id);
        assert (session.getGame() == null);
        assert (session.getPlayer() == null);
        sessionDao.deleteById(id);
        this.debug("/" + session.getId() + " /DELETE");
    }

    @Path(SessionUris.PATH_ID_PARAM + SessionUris.PATH_CREATED_GAME)
    @GET
    public String createdGame(@PathParam("id") Integer id) {
        SessionEntity session = readSession(id);
        Boolean result = session.getGame() != null;
        this.debug("/" + session.getId() + SessionUris.PATH_CREATED_GAME + " /GET:" + result);
        return Boolean.toString(result);
    }

}
