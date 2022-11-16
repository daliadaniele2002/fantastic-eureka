package com.github.fantastic_eureka.sneakers_store_ee_quarkus.controller;

import com.github.fantastic_eureka.sneakers_store_ee_quarkus.model.Image;

import java.util.List;

public interface ImagesController {
    Image getImage(final long id);

    List<Image> getAllImages();

    Image addNewImage(final Image image);

    Image addNewImage();//TODO final MultipartFile multipartFile) throws IOException;

    Image update(final Image image);

    void delete(final Image image);

    void deleteById(final long id);
}
