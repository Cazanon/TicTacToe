package es.art83.ticTacToe.controllers.ws.server;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class SessionClient {
    public static String URI = "http://localhost:8080/TicTacToe/rest/sessions";

    private Response response;

    private Integer id = null;

    public SessionClient() {
        this.response = this.resource().request().post(null);
        this.id = Integer.valueOf(this.response.readEntity(String.class));
    }

    public WebTarget resource() {
        return ClientBuilder.newClient().target(URI);
    }

    public WebTarget resourceId() {
        return this.resource().path(String.valueOf(this.id));
    }

    public Response getResponse() {
        return this.response;
    }

    public Integer getId() {
        return this.id;
    }

    public void close() {
        if (this.id != null) {
            this.resourceId().request().delete();
        }
    }

}
