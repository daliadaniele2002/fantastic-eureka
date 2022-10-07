package com.github.fantastic_eureka.controller;

import com.github.fantastic_eureka.model.Sneakers;

import java.util.List;

public interface SneakersController {
    Sneakers getSneakers(final long id);

    List<Sneakers> getAllSneakers();

    Sneakers addNewSneakers(final Sneakers sneakers);

    Sneakers update(final Sneakers sneakers);

    void delete(final Sneakers sneakers);

    void deleteById(final long id);
}
