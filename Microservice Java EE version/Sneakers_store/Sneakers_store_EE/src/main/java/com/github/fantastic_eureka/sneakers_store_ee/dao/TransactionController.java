package com.github.fantastic_eureka.sneakers_store_ee.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.function.Consumer;


public class TransactionController implements ITransactionController {
    @Override
    public void executeInsideTransaction(Consumer<EntityManager> action, EntityManager entityManager) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            action.accept(entityManager);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }
}
