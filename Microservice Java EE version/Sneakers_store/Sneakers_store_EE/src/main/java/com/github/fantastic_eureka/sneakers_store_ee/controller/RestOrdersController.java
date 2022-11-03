package com.github.fantastic_eureka.sneakers_store_ee.controller;

import com.github.fantastic_eureka.sneakers_store_ee.dao.IGenericDao;
import com.github.fantastic_eureka.sneakers_store_ee.model.Order;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/order")
public class RestOrdersController implements OrdersController {
    private IGenericDao<Order> dao;

    @Inject
    public void setDao(IGenericDao<Order> dao){
        dao.setClazz(Order.class);
        this.dao = dao;
    }
    @Override
    @GET
    @Path("/findOne/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Order getOrder(@PathParam("id") long id) {
        return dao.findOne(id);
    }

    @Override
    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> getAllOrders() {
        return dao.findAll();
    }

    @Override
    @POST
    @Path("/addNew")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Order addNewOrder(Order order) {
        return dao.create(order);
    }

    @Override
    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Order update(Order order) {
        return dao.update(order);
    }

    @Override
    @DELETE
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    public void delete(Order order) {
        dao.delete(order);
    }

    @Override
    @DELETE
    @Path("/deleteById/{id}")
    public void deleteById(@PathParam("id") long id) {
        dao.deleteById(id);
    }
}
