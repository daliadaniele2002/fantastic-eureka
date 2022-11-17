package com.github.fantastic_eureka.sneakers_store_ee_quarkus.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.enterprise.inject.Produces;
import javax.persistence.PersistenceUnit;

public class EntityManagerConfig {

    private EntityManagerFactory emf;
    @PersistenceUnit(unitName = "sneakers_store_EE")
    public void setEmf(EntityManagerFactory emf){
        this.emf = emf;
    }

    @Produces
    @EntityManagerFromFactory
    public EntityManager entityManager(){
        return emf.createEntityManager();
    }
}
