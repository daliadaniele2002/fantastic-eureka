package com.github.fantastic_eureka.sneakers_store_ee_quarkus.controller;

import com.github.fantastic_eureka.sneakers_store_ee_quarkus.model.Sneakers;

import java.util.List;

public interface SneakersController {
    Sneakers getSneakers(final long id);

    List<Sneakers> getAllSneakers();

    Sneakers addNewSneakers();

    Sneakers update(final Sneakers sneakers);

    void delete(final Sneakers sneakers);

    void deleteById(final long id);
}
