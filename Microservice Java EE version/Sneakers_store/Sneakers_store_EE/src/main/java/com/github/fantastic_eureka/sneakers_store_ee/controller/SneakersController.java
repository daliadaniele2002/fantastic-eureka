package com.github.fantastic_eureka.sneakers_store_ee.controller;

import com.github.fantastic_eureka.sneakers_store_ee.model.Sneakers;

import java.util.List;

public interface SneakersController {
    Sneakers getSneakers(final long id);

    List<Sneakers> getAllSneakers();

    Sneakers addNewSneakers(final String sneakersJson);//,TODO MultipartFile file) throws IOException;

    Sneakers update(final Sneakers sneakers);

    void delete(final Sneakers sneakers);

    void deleteById(final long id);
}
