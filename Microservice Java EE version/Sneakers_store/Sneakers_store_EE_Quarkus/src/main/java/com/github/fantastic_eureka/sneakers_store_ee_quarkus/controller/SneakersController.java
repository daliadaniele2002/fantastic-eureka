package com.github.fantastic_eureka.sneakers_store_ee_quarkus.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fantastic_eureka.sneakers_store_ee_quarkus.model.Sneakers;
import com.github.fantastic_eureka.sneakers_store_ee_quarkus.utilities.MultipartBody;

import java.io.IOException;
import java.util.List;

public interface SneakersController {
    Sneakers getSneakers(final long id);

    List<Sneakers> getAllSneakers();

    Sneakers addNewSneakers(MultipartBody body) throws IOException;

    Sneakers update(final Sneakers sneakers);

    void delete(final Sneakers sneakers);

    void deleteById(final long id);
}
