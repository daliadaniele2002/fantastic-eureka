package com.github.fantastic_eureka.sneakers_store_ee_quarkus.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.enterprise.inject.Produces;

public class EntityManagerConfig {
    private final EntityManagerFactory emf;

    public EntityManagerConfig() {
        this.emf = Persistence.createEntityManagerFactory("sneakers_store_EE");
    }

   // @Produces
    public EntityManager entityManager(){
        return emf.createEntityManager();
    }
}
