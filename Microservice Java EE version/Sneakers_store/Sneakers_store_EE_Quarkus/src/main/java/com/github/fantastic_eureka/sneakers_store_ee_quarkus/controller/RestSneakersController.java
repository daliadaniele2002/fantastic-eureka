package com.github.fantastic_eureka.sneakers_store_ee_quarkus.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fantastic_eureka.sneakers_store_ee_quarkus.dao.IGenericDao;
import com.github.fantastic_eureka.sneakers_store_ee_quarkus.model.Image;
import com.github.fantastic_eureka.sneakers_store_ee_quarkus.model.Sneakers;
import com.github.fantastic_eureka.sneakers_store_ee_quarkus.utilities.MultipartBody;
import org.jboss.resteasy.reactive.MultipartForm;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;


@Path("/sneakers")
public class RestSneakersController implements SneakersController {
    private IGenericDao<Sneakers> dao;
    private ImagesController imagesController;
    private ObjectMapper mapper;

    @Inject
    public RestSneakersController(ImagesController imagesController, ObjectMapper mapper) {
        this.imagesController = imagesController;
        this.mapper = mapper;
    }

    @Inject
    public void setDao(IGenericDao<Sneakers> dao) {
        dao.setClazz(Sneakers.class);
        this.dao = dao;
    }

    @Override
    @GET
    @Path("/findOne/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Sneakers getSneakers(@PathParam("id") long id) {
        return dao.findOne(id);
    }

    @Override
    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sneakers> getAllSneakers() {
        return dao.findAll();
    }

    @Override
    @POST
    @Path("/addNew")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Sneakers addNewSneakers(@MultipartForm MultipartBody body) throws IOException {
        Sneakers sneakers = mapper.readValue(body.sneakersJson, Sneakers.class);
        Image image = imagesController.addNewImage(body.file);
        sneakers.setImage(image);
        dao.create(sneakers);
        return sneakers;
    }

    @Override
    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Sneakers update(Sneakers sneakers) {
        return dao.update(sneakers);
    }

    @Override
    @DELETE
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    public void delete(Sneakers sneakers) {
        dao.delete(sneakers);
    }

    @Override
    @DELETE
    @Path("/deleteById/{id}")
    public void deleteById(@PathParam("id") long id) {
        dao.deleteById(id);
    }
}
