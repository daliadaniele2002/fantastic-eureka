package com.github.fantastic_eureka.controller;

import com.github.fantastic_eureka.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImagesController {
    Image getImage(final long id);

    List<Image> getAllImages();

    Image addNewImage(final Image image);

    Image addNewImage(final MultipartFile multipartFile) throws IOException;

    Image update(final Image image);

    void delete(final Image image);

    void deleteById(final long id);
}
