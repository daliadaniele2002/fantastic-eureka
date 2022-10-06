package com.github.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Phone extends Product{
    private double screenDiagonal;
    private int batteryCapacity;
    private int memory;

    public Phone(int id, String model, String manufacturer, double price, int quantity, String type,
                 double screenDiagonal, int batteryCapacity, int memory) {
        super(id, model, manufacturer, price, quantity, type);
        this.screenDiagonal = screenDiagonal;
        this.batteryCapacity = batteryCapacity;
        this.memory = memory;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "screenDiagonal=" + screenDiagonal +
                ", batteryCapacity=" + batteryCapacity +
                ", memory=" + memory +
                super.toString();
    }
}
