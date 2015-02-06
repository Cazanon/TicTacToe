package es.art83.ticTacToe.controllers.ws;

import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;

public class WsManager {
    private WebTarget webTarget;

    private Response response;

    public WsManager(String uri, String... paths) {
        this.webTarget = ClientBuilder.newClient().target(uri);
        for (String path : paths) {
            this.webTarget = this.webTarget.path(path);
        }
        this.response = null;
    }

    private String logMsg(String method) {
        String result = this.webTarget.getUri().toString();
        result += " /" + method;
        result += ":" + this.response.getStatusInfo();
        result += "(" + this.response.getStatus() + ")";
        return result;
    }

    private void log(String method) {
        if (this.response.getStatusInfo().getFamily().equals(Response.Status.Family.CLIENT_ERROR)) {
            LogManager.getLogger(this.getClass()).warn(this.logMsg(method));
        } else if (this.response.getStatusInfo().getFamily()
                .equals(Response.Status.Family.SERVER_ERROR)) {
            LogManager.getLogger(this.getClass()).fatal(this.logMsg(method));
        } else if (this.response.getStatusInfo().getFamily()
                .equals(Response.Status.Family.SUCCESSFUL)) {
            LogManager.getLogger(this.getClass()).debug(this.logMsg(method));
        } else {
            LogManager.getLogger(this.getClass()).error(this.logMsg(method));
        }
    }

    private Response getResponse() {
        if (this.response == null) {
            this.read();
        }
        return this.response;
    }

    public void addPath(String path) {
        this.webTarget = this.webTarget.path(path);
    }

    public void addParams(String name, String value) {
        this.webTarget = this.webTarget.queryParam(name, value);
    }

    public void addMatrixParams(String name, String value) {
        this.webTarget = this.webTarget.matrixParam(name, value);
    }

    public boolean create(Object entity) {
        this.response = this.webTarget.request().post(Entity.xml(entity));
        this.log("POST");
        return this.ok();
    }

    public boolean create() {
        return this.create(null);
    }

    public boolean read() {
        this.response = this.webTarget.request().get();
        this.log("GET");
        return this.ok();
    }

    public boolean update(Object entity) {
        this.response = this.webTarget.request().put(Entity.xml(entity));
        this.log("PUT");
        return this.ok();
    }

    public boolean update() {
        return this.update(null);
    }

    public boolean delete() {
        this.response = this.webTarget.request().delete();
        this.log("DELETE");
        return this.ok();
    }

    public boolean ok() {
        return Response.Status.Family.SUCCESSFUL.equals(response.getStatusInfo().getFamily());
    }

    public <T> T entity(Class<T> clazz) {
        T result = null;
        if (this.getResponse().hasEntity()) {
            result = this.getResponse().readEntity(clazz);
        }
        return result;
    }

    public Boolean entityBoolean() {
        Boolean result = null;
        if (this.getResponse().hasEntity()) {
            result = Boolean.valueOf(this.getResponse().readEntity(String.class));
        }
        return result;
    }

    public <T> List<T> entities(GenericType<List<T>> genericType) {
        List<T> result = null;
        if (this.getResponse().hasEntity()) {
            result = this.getResponse().readEntity(genericType);
        }
        return result;
    }

    @Override
    protected void finalize() throws Throwable {
        this.response.close();
        super.finalize();
    }

}
