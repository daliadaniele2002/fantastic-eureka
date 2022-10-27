package com.github.fantastic_eureka.dao;

import org.springframework.stereotype.Controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;
import java.util.function.Consumer;

@Controller
public class TransactionController implements ITransactionController {
    @Override
    @Transactional
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
