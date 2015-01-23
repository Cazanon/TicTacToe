package es.art83.ticTacToe.controllers.ws.server;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import es.art83.ticTacToe.models.entities.PlayerEntity;

public class SessionPlayerClient {
    private Response response;

    private SessionClient sessionClient;

    private PlayerClient playerClient;

    private WebTarget resource() {
        return this.sessionClient.resourceId().path("player");
    }

    public SessionPlayerClient() {
        this.sessionClient = new SessionClient();
        this.playerClient = new PlayerClient();
    }

    public Response getResponse() {
        return this.response;
    }
    
    public PlayerEntity playerEntity(){
        return this.playerClient.getPlayerEntity();
    }
    
    public WebTarget resourceId(){
        return this.sessionClient.resourceId();
    }

    public void login() {
        this.login(this.playerClient.getPlayerEntity());
    }

    public void login(PlayerEntity playerEntity) {
        this.response = this.resource().request().post(Entity.xml(playerEntity));
    }

    public void logout() {
        this.resource().request().delete();
    }

    public void close() {
        this.logout();
        this.sessionClient.close();
        this.playerClient.close();
    }

}
