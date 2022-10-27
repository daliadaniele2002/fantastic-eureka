package com.github.fantastic_eureka.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Configuration
public class EntityManagerConfig {
    private EntityManagerFactory emf;

    public EntityManagerConfig() {
        emf = Persistence.createEntityManagerFactory("sneakers_store");
    }

    @Bean
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
