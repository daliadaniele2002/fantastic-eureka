package com.github.fantastic_eureka.sneakers_store_ee_quarkus.dao;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.function.Consumer;


@ApplicationScoped
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
