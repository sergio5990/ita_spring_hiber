package by.academy.it.rest.dao;

import java.io.Serializable;

public interface Dao<T> {
    T save(T t);

    T update(T t);

    T get(Serializable id);

    void delete(Serializable id);
}
