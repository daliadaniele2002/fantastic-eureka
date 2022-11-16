package com.github.fantastic_eureka.sneakers_store_ee_quarkus.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao<T extends Serializable> {
    void setClazz(Class<T> clazz);

    T findOne(final long id);

    List<T> findAll();

    T create(final T entity);

    T update(final T entity);

    void delete(final T entity);

    void deleteById(final long id);
}
