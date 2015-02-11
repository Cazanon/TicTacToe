package es.art83.ticTacToe.ws;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.art83.ticTacToe.controllers.ws.WsManager;
import es.art83.ticTacToe.models.utils.StateModel;
import es.art83.ticTacToe.ws.SessionResource;

public class SessionResourceTest extends ResourceTest {

    private String sessionId;

    @Before
    public void testCreate() {
        WsManager webService = new WsManager(URI,
                SessionResource.PATH_SESSIONS);
        assertTrue(webService.create());
        this.sessionId = webService.entity(String.class);
    }

    @Test
    public void testNotLogged() {
        assertFalse(new WsManager(URI,SessionResource.PATH_SESSIONS, this.sessionId,
                SessionResource.PATH_LOGGED).entityBoolean());
    }

    @Test
    public void testStateInitial() {
        StateModel state = new WsManager(URI,
                SessionResource.PATH_SESSIONS, this.sessionId, SessionResource.PATH_STATE)
                .entity(StateModel.class);
        assertEquals(StateModel.INITIAL, state);
    }

    @Test
    public void testSavedGameInitial() {
        assertTrue(new WsManager(URI,SessionResource.PATH_SESSIONS, this.sessionId,
                SessionResource.PATH_SAVED_GAME).entityBoolean());
    }

    @After
    public void deleteSession() {
        new WsManager(URI,SessionResource.PATH_SESSIONS, this.sessionId).delete();
    }

}
