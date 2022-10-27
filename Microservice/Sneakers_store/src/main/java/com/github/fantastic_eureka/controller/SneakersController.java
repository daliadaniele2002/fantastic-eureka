package com.github.fantastic_eureka.controller;

import com.github.fantastic_eureka.model.Sneakers;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface SneakersController {
    Sneakers getSneakers(final long id);

    List<Sneakers> getAllSneakers();

    Sneakers addNewSneakers(final String sneakersJson, MultipartFile file) throws IOException;

    Sneakers update(final Sneakers sneakers);

    void delete(final Sneakers sneakers);

    void deleteById(final long id);
}
