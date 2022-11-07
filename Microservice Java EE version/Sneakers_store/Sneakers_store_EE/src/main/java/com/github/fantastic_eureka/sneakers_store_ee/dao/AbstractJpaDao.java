package com.github.fantastic_eureka.sneakers_store_ee.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractJpaDao<T extends Serializable> {
    private Class<T> clazz;
    @PersistenceContext(name = "sneakers_store_EE")
    private EntityManager entityManager;
    @Inject
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

    public T update(final T entity) {
        transactionController.executeInsideTransaction(em -> em.merge(entity), entityManager);
        return entity;
    }

    public void delete(final T entity) {
        transactionController.executeInsideTransaction(em -> em.remove(entity), entityManager);
    }

    public void deleteById(final long id) {
        T entity = findOne(id);
        transactionController.executeInsideTransaction(em -> em.remove(entity), entityManager);
    }
}
