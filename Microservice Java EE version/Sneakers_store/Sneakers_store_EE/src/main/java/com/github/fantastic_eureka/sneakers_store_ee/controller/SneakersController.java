package com.github.fantastic_eureka.sneakers_store_ee.controller;

import com.github.fantastic_eureka.sneakers_store_ee.model.Sneakers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface SneakersController {
    Sneakers getSneakers(final long id);

    List<Sneakers> getAllSneakers();

    HttpServletResponse addNewSneakers(final HttpServletRequest request, HttpServletResponse response);

    Sneakers update(final Sneakers sneakers);

    void delete(final Sneakers sneakers);

    void deleteById(final long id);
}
