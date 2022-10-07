package com.github.fantastic_eureka.controller;

import com.github.fantastic_eureka.model.Size;
import com.github.fantastic_eureka.model.Sneakers;

import java.util.List;

public interface SizesController {
    Size getSneakers(final long id);

    List<Size> getAllSneakers();

    Size addNewSize(final Size size);

    Size update(final Size size);

    void delete(final Size size);

    void deleteById(final long id);
}
