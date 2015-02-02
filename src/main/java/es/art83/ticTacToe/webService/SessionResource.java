package es.art83.ticTacToe.webService;

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

import es.art83.ticTacToe.models.daos.DAOFactory;
import es.art83.ticTacToe.models.daos.SessionDAO;
import es.art83.ticTacToe.models.entities.SessionEntity;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

@Path(SessionResource.PATH_SESSIONS)
public class SessionResource {

    public static final String PATH_SESSIONS = "/sessions";

    public static final String PATH_ID_PARAM = "/{id}";

    public static final String PATH_LOGGED = "/logged";

    public static final String PATH_STATE = "/state";

    public static final String PATH_SAVED_GAME = "/savedGame";

    public static final String PATH_CREATED_GAME = "/createdGame";

    protected void debug(String msg) {
        LogManager.getLogger(this.getClass()).debug(PATH_SESSIONS + msg);
    }

    protected SessionEntity readSessionEntity(Integer id) {
        SessionEntity sessionEntity = DAOFactory.getFactory().getSessionDAO().read(id);
        if (sessionEntity != null) {
            return sessionEntity;
        } else {
            throw new NotFoundException("Sesion (" + id + ") no existe");
        }
    }

    @POST
    public Response create() {
        SessionEntity sessionEntity = new SessionEntity();
        DAOFactory.getFactory().getSessionDAO().create(sessionEntity);
        this.debug(" POST/ sessionId: " + sessionEntity.getId());
        return Response.created(URI.create(PATH_SESSIONS + "/" + sessionEntity.getId()))
                .entity(String.valueOf(sessionEntity.getId())).build();
    }

    @Path(PATH_ID_PARAM + SessionResource.PATH_LOGGED)
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String logged(@PathParam("id") Integer id) {
        SessionEntity sessionEntity = this.readSessionEntity(id);
        Boolean result = sessionEntity.getPlayerEntity() != null;
        this.debug("/" + sessionEntity.getId() + PATH_LOGGED + " /GET: " + result);
        return Boolean.toString(result);
    }

    @Path(PATH_ID_PARAM + PATH_STATE)
    @GET
    public TicTacToeStateModel state(@PathParam("id") Integer id) {
        SessionEntity sessionEntity = this.readSessionEntity(id);
        TicTacToeStateModel result = sessionEntity.getTicTacToeStateModel();
        this.debug("/" + sessionEntity.getId() + PATH_STATE + " /GET: " + result);
        return result;
    }

    @Path(PATH_ID_PARAM + PATH_SAVED_GAME)
    @GET
    public String savedGame(@PathParam("id") Integer id) {
        SessionEntity sessionEntity = this.readSessionEntity(id);
        Boolean result = sessionEntity.isSavedGame();
        this.debug(sessionEntity.getId() + SessionResource.PATH_SAVED_GAME + " /GET: " + result);
        return Boolean.toString(result);
    }

    @Path(PATH_ID_PARAM)
    @DELETE
    public void delete(@PathParam("id") Integer id) {
        SessionDAO sessionDAO = DAOFactory.getFactory().getSessionDAO();
        SessionEntity sessionEntity = sessionDAO.read(id);
        assert (sessionEntity.getGameEntity() == null);
        assert (sessionEntity.getPlayerEntity() == null);
        sessionDAO.deleteByID(id);
        this.debug("/" + sessionEntity.getId() + " /DELETE");
    }

    @Path(PATH_ID_PARAM + PATH_CREATED_GAME)
    @GET
    public String createdGame(@PathParam("id") Integer id) {
        SessionEntity sessionEntity = this.readSessionEntity(id);
        Boolean result = sessionEntity.getGameEntity() != null;
        this.debug("/" + sessionEntity.getId() + PATH_CREATED_GAME + " /GET:" + result);
        return Boolean.toString(result);
    }

}
