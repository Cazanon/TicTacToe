package es.art83.ticTacToe.controllers.ws.client.utils;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class WebServiceClient {
    private WebTarget webTarget;

    private Object entity;

    private Response response;

    public WebServiceClient(Object entity, String... paths) {
        this.webTarget = ClientBuilder.newClient().target(TicTacToeResource.URI);
        for (String path : paths) {
            this.webTarget = this.webTarget.path(path);
        }
        this.entity = entity;
    }

    public WebServiceClient(String... paths) {
        this(null, paths);
    }

    public WebServiceClient() {
        this.entity = null;
    }

    public void addPath(String path) {
        this.webTarget = this.webTarget.path(path);
    }

    public void addParams(String name, String value) {
        this.webTarget = this.webTarget.queryParam(name, value);
    }

    // entity debe contener @XmlRootElement
    public void setEntity(Object entity) {
        this.entity = entity;
    }

    public boolean create() {
        this.response = this.webTarget.request().post(Entity.xml(this.entity));
        return this.ok();
    }

    public boolean read() {
        this.response = this.webTarget.request().get();
        return this.ok();
    }

    public boolean update() {
        this.response = this.webTarget.request().put(Entity.xml(this.entity));
        return this.ok();
    }

    public boolean delete() {
        this.response = this.webTarget.request().delete();
        return this.ok();
    }

    public boolean ok() {
        return Response.Status.Family.SUCCESSFUL.equals(response.getStatusInfo().getFamily());
    }

    public Boolean entityBoolean() {
        Boolean result = null;
        if (this.response.hasEntity()) {
            result = Boolean.valueOf(this.response.readEntity(String.class));
        }
        return result;
    }

    public Integer entityInteger() {
        Integer result = null;
        if (this.response.hasEntity()) {
            result = Integer.valueOf(this.response.readEntity(String.class));
        }
        return result;
    }

    public String entityString() {
        String result = null;
        if (this.response.hasEntity()) {
            result = this.response.readEntity(String.class);
        }
        return result;
    }

    public Object entityObject(Class<?> clazz) {
        Object result = null;
        if (this.response.hasEntity()) {
            result = this.response.readEntity(clazz);
        }
        return result;
    }

    @Override
    protected void finalize() throws Throwable {
        this.response.close();
        super.finalize();
    }

}
