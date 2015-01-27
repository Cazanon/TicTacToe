package es.art83.ticTacToe.controllers.ws.client.utils;

import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class WebServiceClient<T> {
    private WebTarget webTarget;

    private Response response;

    public WebServiceClient(String... paths) {
        this.webTarget = ClientBuilder.newClient().target(TicTacToeResource.URI);
        for (String path : paths) {
            this.webTarget = this.webTarget.path(path);
        }
    }

    public void addPath(String path) {
        this.webTarget = this.webTarget.path(path);
    }

    public void addParams(String name, String value) {
        this.webTarget = this.webTarget.queryParam(name, value);
    }

    public boolean create(Object entity) {
        this.response = this.webTarget.request().post(Entity.xml(entity));
        System.out.println("------>>>> : " + response.toString());
        return this.ok();
    }

    public boolean create() {
        return this.create(null);
    }

    public boolean read() {
        this.response = this.webTarget.request().get();
        System.out.println("------>>>> : " + response.toString());
        return this.ok();
    }

    public boolean update(Object entity) {
        this.response = this.webTarget.request().put(Entity.xml(entity));
        System.out.println("------>>>> : " + response.toString());
        return this.ok();
    }

    public boolean update() {
        return this.update(null);
    }

    public boolean delete() {
        this.response = this.webTarget.request().delete();
        System.out.println("------>>>> : " + response.toString());
        return this.ok();
    }

    public boolean ok() {
        return Response.Status.Family.SUCCESSFUL.equals(response.getStatusInfo().getFamily());
    }

    public T entity(Class<T> clazz) {
        T result = null;
        if (this.response.hasEntity()) {
            result = this.response.readEntity(clazz);
        }
        return result;
    }
    
    public Boolean entityBoolean(){
        Boolean result = null;
        if (this.response.hasEntity()) {
            result = Boolean.valueOf(this.response.readEntity(String.class));
        }
        return result;
    }
    
    public List<T> entities() {
        List<T> result = null;
        if (this.response.hasEntity()) {
            result = this.response.readEntity(new GenericType<List<T>>() {
            });
        }
        return result;
    }

    @Override
    protected void finalize() throws Throwable {
        this.response.close();
        super.finalize();
    }

}
