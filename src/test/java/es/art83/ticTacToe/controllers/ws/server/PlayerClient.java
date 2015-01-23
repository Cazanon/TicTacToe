package es.art83.ticTacToe.controllers.ws.server;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import es.art83.ticTacToe.models.entities.PlayerEntity;

public class PlayerClient {
    public static String URI = "http://localhost:8080/TicTacToe/rest/players";

    private Response response;

    private PlayerEntity playerEntity;

    public WebTarget resource() {
        return ClientBuilder.newClient().target(URI);
    }

    public PlayerClient() {
        this.playerEntity = new PlayerEntity("u", "pass");
        this.response = this.resource().request().post(Entity.xml(playerEntity));
    }

    public Response getResponse() {
        return response;
    }

    public PlayerEntity getPlayerEntity() {
        return playerEntity;
    }

    public void close() {
        this.resource().path(this.playerEntity.getUser()).request().delete();
    }

}
