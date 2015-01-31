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
import es.art83.ticTacToe.webService.utils.WS;

@Path(WS.PATH_SESSIONS)
public class SessionResource {

    protected void info(String msg) {
        LogManager.getLogger(this.getClass()).info(WS.PATH_SESSIONS + msg);
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
        this.info(" POST/ sessionId: " + sessionEntity.getId());
        return Response.created(URI.create(WS.PATH_SESSIONS + "/" + sessionEntity.getId()))
                .entity(String.valueOf(sessionEntity.getId())).build();
    }

    @Path(WS.PATH_ID_PARAM + WS.PATH_LOGGED)
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String logged(@PathParam("id") Integer id) {
        SessionEntity sessionEntity = this.readSessionEntity(id);
        Boolean result = sessionEntity.getPlayer() != null;
        this.info("/" + sessionEntity.getId() + WS.PATH_LOGGED + " /GET: " + result);
        return Boolean.toString(result);
    }

    @Path(WS.PATH_ID_PARAM + WS.PATH_STATE)
    @GET
    public TicTacToeStateModel state(@PathParam("id") Integer id) {
        SessionEntity sessionEntity = this.readSessionEntity(id);
        TicTacToeStateModel result = sessionEntity.getTicTacToeStateModel();
        this.info("/" + sessionEntity.getId() + WS.PATH_STATE + " /GET: " + result);
        return result;
    }

    @Path(WS.PATH_ID_PARAM + WS.PATH_SAVED_GAME)
    @GET
    public String savedGame(@PathParam("id") Integer id) {
        SessionEntity sessionEntity = this.readSessionEntity(id);
        Boolean result = sessionEntity.isSavedGame();
        this.info(sessionEntity.getId() + WS.PATH_SAVED_GAME + " /GET: " + result);
        return Boolean.toString(result);
    }

    @Path(WS.PATH_ID_PARAM)
    @DELETE
    public void delete(@PathParam("id") Integer id) {
        SessionDAO sessionDAO = DAOFactory.getFactory().getSessionDAO();
        SessionEntity sessionEntity = sessionDAO.read(id);
        assert (sessionEntity.getGame() == null);
        assert (sessionEntity.getPlayer() == null);
        sessionDAO.deleteByID(id);
        this.info("/" + sessionEntity.getId() + " /DELETE");
    }

    @Path(WS.PATH_ID_PARAM + WS.PATH_CREATED_GAME)
    @GET
    public String createdGame(@PathParam("id") Integer id) {
        SessionEntity sessionEntity = this.readSessionEntity(id);
        Boolean result = sessionEntity.getGame() != null;
        this.info("/" + sessionEntity.getId() + WS.PATH_CREATED_GAME + " /GET:" + result);
        return Boolean.toString(result);
    }

}
