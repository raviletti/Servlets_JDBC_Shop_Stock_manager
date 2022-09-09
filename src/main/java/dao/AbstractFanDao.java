package dao;

import java.util.List;


    public interface AbstractFanDao<K extends Number, S extends String, T>{

        public abstract List<T> findAll();

        public abstract T findById(K id);

        public abstract List<T> findByModelName(S name);

        public abstract List<T> findByProducer(S producer);

        public boolean deleteById(K id);

        public abstract boolean delete(T entity);

        public abstract boolean create(T entity);

        public abstract T update(T entity);
    }

