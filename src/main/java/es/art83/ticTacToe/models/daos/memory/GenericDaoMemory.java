package es.art83.ticTacToe.models.daos.memory;

import java.util.ArrayList;
import java.util.List;

import es.art83.ticTacToe.models.daos.GenericDao;

public abstract class GenericDaoMemory<T, ID> implements GenericDao<T, ID> {
    private List<T> entityList;

    public GenericDaoMemory() {
        this.entityList = new ArrayList<>();
    }

    public List<T> getEntityList() {
        return entityList;
    }
    
    //@Override
    public void delete(T entity) {
        entityList.remove(entity);
    }

    @Override
    public List<T> findAll() {
        return null;
    }

}
