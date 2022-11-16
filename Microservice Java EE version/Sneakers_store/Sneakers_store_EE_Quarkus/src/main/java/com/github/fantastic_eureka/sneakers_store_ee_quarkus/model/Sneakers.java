package com.github.fantastic_eureka.sneakers_store_ee_quarkus.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "sneakers")
public class Sneakers implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code", nullable = false, unique = true)
    private long code;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "price")
    private double price;
    @OneToOne()
    private Image image;
    @Column(name = "sizes")
    @ElementCollection(fetch = FetchType.EAGER)
    @OrderColumn(name = "index")
    private Set<Double> sizes = new HashSet<>();

    @Override
    public String toString() {
        return "Sneakers{" +
                "code=" + code +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", image=" + image +
                ", sizes=" + sizes +
                '}';
    }


}
