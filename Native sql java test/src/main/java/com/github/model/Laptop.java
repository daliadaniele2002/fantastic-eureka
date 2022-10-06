package com.github.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Laptop extends Product{
    private double screenDiagonal;
    private int batteryCapacity;
    private String CPU;
    private String RAM;

    public Laptop(int id, String model, String manufacturer, double price, int quantity, String type,
                  double screenDiagonal, int batteryCapacity, String cpu, String ram) {
        super(id, model, manufacturer, price, quantity, type);
        this.screenDiagonal = screenDiagonal;
        this.batteryCapacity = batteryCapacity;
        CPU = cpu;
        RAM = ram;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "screenDiagonal=" + screenDiagonal +
                ", batteryCapacity=" + batteryCapacity +
                ", CPU='" + CPU + '\'' +
                ", RAM='" + RAM + '\'' +
                super.toString();
    }
}
