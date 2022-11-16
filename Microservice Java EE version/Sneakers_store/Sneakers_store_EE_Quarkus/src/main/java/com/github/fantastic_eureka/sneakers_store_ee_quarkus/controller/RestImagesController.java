package com.github.fantastic_eureka.sneakers_store_ee_quarkus.controller;

import com.github.fantastic_eureka.sneakers_store_ee_quarkus.model.Image;

import javax.ws.rs.*;
import java.util.List;

public class RestImagesController implements ImagesController{
    @Override
    @GET
    @Path("/")
    public Image getImage(long id) {
        return null;
    }

    @Override
    @GET
    @Path("/")
    public List<Image> getAllImages() {
        return null;
    }

    @Override
    @POST
    @Path("/")
    public Image addNewImage(Image image) {
        return null;
    }

    @Override
    @POST
    @Path("/addNew")
    public Image addNewImage() {
        return null;
    }

    @Override
    @PUT
    @Path("/update")
    public Image update(Image image) {
        return null;
    }

    @Override
    @DELETE
    @Path("/delete")
    public void delete(Image image) {

    }

    @Override
    @DELETE
    @Path("/deleteById")
    public void deleteById(long id) {

    }
}
