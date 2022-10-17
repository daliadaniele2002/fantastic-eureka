package com.github.fantastic_eureka.dao;

import javax.persistence.EntityManager;
import java.util.function.Consumer;

public interface ITransactionController {
    void executeInsideTransaction(Consumer<EntityManager> action, EntityManager entityManager);
}
