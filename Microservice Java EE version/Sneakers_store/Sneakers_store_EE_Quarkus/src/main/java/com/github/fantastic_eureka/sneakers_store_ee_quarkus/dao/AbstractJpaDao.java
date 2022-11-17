package com.github.fantastic_eureka.sneakers_store_ee_quarkus.dao;

import com.github.fantastic_eureka.sneakers_store_ee_quarkus.config.EntityManagerFromFactory;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractJpaDao<T extends Serializable> {
    private Class<T> clazz;
    private EntityManager entityManager;
    private ITransactionController transactionController;

    public final void setClazz(final Class<T> clazz) {
        this.clazz = clazz;
    }

    @Inject
    @EntityManagerFromFactory
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Inject
    public void setTransactionController(ITransactionController transactionController) {
        this.transactionController = transactionController;
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
