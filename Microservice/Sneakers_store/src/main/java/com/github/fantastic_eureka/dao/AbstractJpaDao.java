package com.github.fantastic_eureka.dao;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractJpaDao<T extends Serializable> {
    private Class<T> clazz;
    @Autowired
    private EntityManager entityManager;

    public final void setClazz(final Class<T> clazz) {
        this.clazz = clazz;
    }

    public T findOne(final long id) {
        return entityManager.find(clazz, id);
    }

    public List<T> findAll() {
        return entityManager.createQuery("from " + clazz.getName()).getResultList();
    }

    public T create(final T entity) {
        entityManager.persist(entity);
        return entity;
    }

    public T update(final T entity){
        return entityManager.merge(entity);
    }

    public void delete(final T entity){
        entityManager.remove(entity);
    }

    public void deleteById(final long id){
        T entity = findOne(id);
        entityManager.remove(entity);
    }

}
