package com.github.fantastic_eureka.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "size_to_sneakers",
            joinColumns = {@JoinColumn(name = "sneakers_code")},
            inverseJoinColumns = {@JoinColumn(name = "size_id")}
    )
    private Set<Size> sizes = new HashSet<>();

    @Override
    public String toString() {
        return "Sneakers{" +
                "code=" + code +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", sizes=" + sizes +
                '}';
    }
}
