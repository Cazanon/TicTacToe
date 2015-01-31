package es.art83.ticTacToe.webService;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.art83.ticTacToe.models.utils.TicTacToeStateModel;
import es.art83.ticTacToe.webService.utils.WS;
import es.art83.ticTacToe.webService.utils.WebServiceClient;

public class SessionResourceTest {

    private String sessionId;

    @Before
    public void testCreate() {
        WebServiceClient<String> webService = new WebServiceClient<>(
                WS.PATH_SESSIONS);
        assertTrue(webService.create());
        this.sessionId = webService.entity(String.class);
    }

    @Test
    public void testNotLogged() {
        assertFalse(new WebServiceClient<>(WS.PATH_SESSIONS, this.sessionId,
                WS.PATH_LOGGED).entityBoolean());
    }

    @Test
    public void testStateInitial() {
        TicTacToeStateModel state = new WebServiceClient<TicTacToeStateModel>(
                WS.PATH_SESSIONS, this.sessionId, WS.PATH_STATE)
                .entity(TicTacToeStateModel.class);
        assertEquals(TicTacToeStateModel.INITIAL, state);
    }

    @Test
    public void testSavedGameInitial() {
        assertTrue(new WebServiceClient<>(WS.PATH_SESSIONS, this.sessionId,
                WS.PATH_SAVED_GAME).entityBoolean());
    }

    @After
    public void deleteSession() {
        new WebServiceClient<>(WS.PATH_SESSIONS, this.sessionId).delete();
    }

}
