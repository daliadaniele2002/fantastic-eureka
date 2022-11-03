package com.github.fantastic_eureka.sneakers_store_ee.controller;

import com.github.fantastic_eureka.sneakers_store_ee.dao.IGenericDao;
import com.github.fantastic_eureka.sneakers_store_ee.model.Sneakers;

import javax.inject.Inject;
import javax.servlet.annotation.MultipartConfig;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@MultipartConfig
@Path("/sneakers")
public class RestSneakersController implements SneakersController{
    private IGenericDao<Sneakers> dao;

    @Inject
    public void setDao(IGenericDao<Sneakers> dao){
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
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Sneakers addNewSneakers(String sneakersJson){//, HttpServletRequest request, HttpServletResponse response) {
        //TODO
        return null;
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
