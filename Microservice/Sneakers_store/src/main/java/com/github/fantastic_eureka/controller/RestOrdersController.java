package com.github.fantastic_eureka.controller;

import com.github.fantastic_eureka.dao.IGenericDao;
import com.github.fantastic_eureka.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
public class RestOrdersController implements OrdersController {
    private IGenericDao<Order> dao;

    @Autowired
    public void setDao(IGenericDao<Order> dao) {
        this.dao = dao;
        dao.setClazz(Order.class);
    }

    @Override
    @GetMapping("/findOne")
    public Order getOrder(@RequestParam long id) {
        return dao.findOne(id);
    }

    @Override
    @GetMapping("/findAll")
    public List<Order> getAllOrders() {
        return dao.findAll();
    }

    @Override
    @PostMapping("/addNew")
    public Order addNewOrder(@RequestBody Order order) {
        dao.create(order);
        return order;
    }
    @Override
    @PutMapping("/update")
    public Order update(@RequestBody Order order) {
        dao.update(order);
        return order;
    }

    @Override
    @DeleteMapping("/delete")
    public void delete(@RequestBody Order order) {
        dao.delete(order);
    }

    @Override
    @DeleteMapping("deleteById")
    public void deleteById(@RequestParam long id) {
        dao.deleteById(id);
    }
}
