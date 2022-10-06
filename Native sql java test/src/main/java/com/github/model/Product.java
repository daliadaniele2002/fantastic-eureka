package com.github.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
abstract public class Product {
    private int id;
    private String model;
    private String manufacturer;
    private double price;
    private int quantity;
    private String type;

    public Product(int id, String model, String manufacturer, double price, int quantity, String type) {
        this.id = id;
        this.model = model;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
    }

    @Override
    public String toString() {
        return  "model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", type=" + type +
                '}';
    }
}
