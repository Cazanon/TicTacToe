package es.art83.ticTacToe.controllers.ws.server;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class SessionGameClient {

    private SessionPlayerClient sessionPlayerClient;

    private Response responde;

    public SessionGameClient() {
        this.sessionPlayerClient = new SessionPlayerClient();
    }

    public Response getResponse() {
        return responde;
    }

    public WebTarget resource() {
        return this.sessionPlayerClient.resourceId().path("game");
    }

    public void login(){
        this.sessionPlayerClient.login();
    }
    
    public void createNewGame(){
        this.responde = this.resource().request().post(null);
    }
    
    public void close() {
        this.sessionPlayerClient.close();
    }

}
