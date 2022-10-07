package com.github.fantastic_eureka.controller;

import com.github.fantastic_eureka.dao.IGenericDao;
import com.github.fantastic_eureka.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestOrdersController implements OrdersController {
    private IGenericDao<Order> dao;

    @Autowired
    public void setDao(IGenericDao<Order> dao) {
        this.dao = dao;
        dao.setClazz(Order.class);
    }

    @Override
    public Order getOrder(long id) {
        return dao.findOne(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return dao.findAll();
    }

    @Override
    public Order addNewOrder(Order order) {
        dao.create(order);
        return order;
    }

    @Override
    public Order update(Order order) {
        dao.update(order);
        return order;
    }

    @Override
    public void delete(Order order) {
        dao.delete(order);
    }

    @Override
    public void deleteById(long id) {
        dao.deleteById(id);
    }
}
