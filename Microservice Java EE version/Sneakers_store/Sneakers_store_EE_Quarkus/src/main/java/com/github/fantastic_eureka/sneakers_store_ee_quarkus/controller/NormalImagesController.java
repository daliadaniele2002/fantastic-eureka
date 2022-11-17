package com.github.fantastic_eureka.sneakers_store_ee_quarkus.controller;

import com.github.fantastic_eureka.sneakers_store_ee_quarkus.dao.IGenericDao;
import com.github.fantastic_eureka.sneakers_store_ee_quarkus.model.Image;
import com.github.fantastic_eureka.sneakers_store_ee_quarkus.utilities.IImageCreator;
import org.jboss.resteasy.reactive.multipart.FileUpload;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.io.IOException;

@Dependent
public class NormalImagesController implements ImagesController{
    private IGenericDao<Image> dao;
    private IImageCreator imageCreator;

    @Inject
    public NormalImagesController(IImageCreator imageCreator) {
        this.imageCreator = imageCreator;
    }

    @Inject
    public void setDao(IGenericDao<Image> dao) {
        dao.setClazz(Image.class);
        this.dao = dao;
    }

    @Override
    public Image addNewImage(FileUpload file) throws IOException {
        Image image = imageCreator.create(file);
        return image;
        //return dao.create(image);
    }
}
