package com.github.fantastic_eureka.sneakers_store_ee_quarkus.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id", nullable = false, unique = true)
    private long id;
    @Column(name = "shipping_address")
    private String address;
    @Column(name = "customer_full_name")
    private String customerFullName;
    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "sneakers_to_orders",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "sneakers_code")}
    )
    private List<Sneakers> sneakers = new ArrayList<>();

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", customerFullName='" + customerFullName + '\'' +
                ", sneakers=" + sneakers +
                '}';
    }
}
