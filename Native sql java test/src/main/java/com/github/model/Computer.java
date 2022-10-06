package com.github.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Computer extends Product{
    private String cpu;
    private String ram;
    private int power;

    public Computer(int id, String model, String manufacturer, double price, int quantity, String type, String cpu,
                    String ram, int power) {
        super(id, model, manufacturer, price, quantity, type);
        this.cpu = cpu;
        this.ram = ram;
        this.power = power;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", power=" + power +
                super.toString();
    }
}
