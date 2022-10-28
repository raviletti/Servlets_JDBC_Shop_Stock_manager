package service;

import java.util.List;

public interface StockManagerService<K extends Number, S extends String, T>{
    public abstract List<T> findAll();

    public abstract T findById(K id);

    public abstract T findByModelName(S name);

    public abstract List<T> findByProducer(S producer);

    public boolean deleteById(K id);

    public abstract boolean delete(T entity);

    public abstract boolean create(T entity);

    public abstract boolean update(T entity);

}
