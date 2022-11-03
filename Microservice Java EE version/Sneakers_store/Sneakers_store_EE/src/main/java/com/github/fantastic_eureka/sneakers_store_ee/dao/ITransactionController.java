package com.github.fantastic_eureka.sneakers_store_ee.dao;

import jakarta.persistence.EntityManager;

import java.util.function.Consumer;

public interface ITransactionController {
    void executeInsideTransaction(Consumer<EntityManager> action, EntityManager entityManager);
}
