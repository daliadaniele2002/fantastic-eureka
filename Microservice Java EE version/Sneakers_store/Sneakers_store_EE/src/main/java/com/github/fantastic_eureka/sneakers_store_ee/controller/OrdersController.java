package com.github.fantastic_eureka.sneakers_store_ee.controller;

import com.github.fantastic_eureka.sneakers_store_ee.model.Order;

import java.util.List;

public interface OrdersController {
    Order getOrder(final long id);

    List<Order> getAllOrders();

    Order addNewOrder(final Order order);

    Order update();//TODO final Order order);

    void delete(final Order order);

    void deleteById(final long id);
}
