package es.art83.ticTacToe.controllers.ws.server;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class SessionGameClient {

    private SessionPlayerClient sessionPlayerClient;

    private Response response;

    public SessionGameClient() {
        this.sessionPlayerClient = new SessionPlayerClient();
    }

    public Response getResponse() {
        return response;
    }

    public WebTarget resource() {
        return this.sessionPlayerClient.resourceId().path("game");
    }

    public void login() {
        this.sessionPlayerClient.login();
    }

    public void createNewGame() {
        this.response = this.resource().request().post(null);
    }

    public void get(String path) {
        this.response = this.resource().path(path).request().get();
    }

    public void post(String path, Object entity) {
        this.response = this.resource().path(path).request().post(Entity.xml(entity));
    }

    public void delete(String path, int row, int column) {
        this.response = this.resource().path(path).matrixParam("row", row)
                .matrixParam("column", column).request().delete();
    }

    public void close() {
        this.sessionPlayerClient.close();
    }

}
