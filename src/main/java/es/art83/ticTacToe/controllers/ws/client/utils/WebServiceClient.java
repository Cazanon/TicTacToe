package es.art83.ticTacToe.controllers.ws.client.utils;

import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;

public class WebServiceClient<T> {
    private WebTarget webTarget;

    private Response response;

    public WebServiceClient(String... paths) {
        this.webTarget = ClientBuilder.newClient().target(TicTacToeResource.URI);
        for (String path : paths) {
            this.webTarget = this.webTarget.path(path);
        }
        this.response = null;
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
        this.log();
        return this.ok();
    }

    public boolean create() {
        return this.create(null);
    }

    public boolean read() {
        this.response = this.webTarget.request().get();
        this.log();
        return this.ok();
    }

    public boolean update(Object entity) {
        this.response = this.webTarget.request().put(Entity.xml(entity));
        this.log();
        return this.ok();
    }

    public boolean update() {
        return this.update(null);
    }

    public boolean delete() {
        this.response = this.webTarget.request().delete();
        this.log();
        return this.ok();
    }

    public boolean ok() {
        return Response.Status.Family.SUCCESSFUL.equals(response.getStatusInfo().getFamily());
    }

    public T entity(Class<T> clazz) {
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

    public List<T> entities(GenericType<List<T>> genericType) {
        List<T> result = null;
        if (this.getResponse().hasEntity()) {
            result = this.getResponse().readEntity(genericType);
        }
        return result;
    }

    private void log() {
        if (this.response.getStatusInfo().getFamily().equals(Response.Status.Family.CLIENT_ERROR)) {
            LogManager.getLogger(this.getClass()).error(this.logMsg());
        } else if (this.response.getStatusInfo().getFamily()
                .equals(Response.Status.Family.SERVER_ERROR)) {
            LogManager.getLogger(this.getClass()).fatal(this.logMsg());
        } else if (this.response.getStatusInfo().getFamily()
                .equals(Response.Status.Family.SUCCESSFUL)) {
            LogManager.getLogger(this.getClass()).info(this.logMsg());
        } else {
            LogManager.getLogger(this.getClass()).warn(this.logMsg());
        }
    }

    private String logMsg() {
        String result = "";
        result += this.response.toString();
        return result;
    }

    @Override
    protected void finalize() throws Throwable {
        this.response.close();
        super.finalize();
    }

}
