package com.github.fantastic_eureka.dao;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractJpaDao<T extends Serializable> {
    private Class<T> clazz;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private ITransactionController transactionController;

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
        transactionController.executeInsideTransaction(em -> em.persist(entity), entityManager);
        return entity;
    }

    public T update(final T entity){
        transactionController.executeInsideTransaction(em -> em.merge(entity), entityManager);
        return entity;
    }

    public void delete(final T entity){
        transactionController.executeInsideTransaction(em -> em.remove(entity), entityManager);
    }

    public void deleteById(final long id){
        T entity = findOne(id);
        transactionController.executeInsideTransaction(em -> em.remove(entity), entityManager);
    }

}
