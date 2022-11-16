package com.github.fantastic_eureka.sneakers_store_ee_quarkus.controller;

import com.github.fantastic_eureka.sneakers_store_ee_quarkus.dao.IGenericDao;
import com.github.fantastic_eureka.sneakers_store_ee_quarkus.model.Sneakers;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

//@MultipartConfig
@Path("/sneakers")
public class RestSneakersController implements SneakersController {
    private IGenericDao<Sneakers> dao;

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
    //@Consumes("multipart/mixed")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Sneakers addNewSneakers() {
        //TODO
        return null;
    }

    @POST
    @Path("/addNew1")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public String addNewSneakers1() throws IOException {

        return "Ok";
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
