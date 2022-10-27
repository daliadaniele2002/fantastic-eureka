package com.github.fantastic_eureka.controller;

import com.github.fantastic_eureka.dao.IGenericDao;
import com.github.fantastic_eureka.model.Image;
import com.github.fantastic_eureka.utilities.IImageCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class RestImagesController implements ImagesController {
    private IGenericDao<Image> dao;
    private IImageCreator imageCreator;

    @Autowired
    public RestImagesController(IImageCreator imageCreator) {
        this.imageCreator = imageCreator;
    }

    @Autowired
    public void setDao(IGenericDao<Image> dao) {
        this.dao = dao;
        dao.setClazz(Image.class);
    }

    @Override
    public Image getImage(long id) {
        return dao.findOne(id);
    }

    @Override
    public List<Image> getAllImages() {
        return dao.findAll();
    }

    @Override
    public Image addNewImage(Image image) {
        return dao.create(image);
    }

    @Override
    public Image addNewImage(MultipartFile multipartFile) throws IOException {
        Image image = imageCreator.create(multipartFile);
        dao.create(image);
        return image;
    }

    @Override
    public Image update(Image image) {
        return dao.update(image);
    }

    @Override
    public void delete(Image image) {
        dao.delete(image);
    }

    @Override
    public void deleteById(long id) {
        dao.deleteById(id);
    }
}
