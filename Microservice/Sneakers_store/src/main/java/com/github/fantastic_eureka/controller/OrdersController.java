package com.github.fantastic_eureka.controller;

import com.github.fantastic_eureka.model.Order;

import java.util.List;

public interface OrdersController {
    Order getOrder(final long id);

    List<Order> getAllOrders();

    Order addNewOrder(final Order order);

    Order update(final Order order);

    void delete(final Order order);

    void deleteById(final long id);
}
