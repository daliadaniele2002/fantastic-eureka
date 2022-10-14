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
@Table(name = "sizes")
public class Size implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "size_id", nullable = false, unique = true)
    private long id;
    @Column(name = "eu_size")
    private double eu_size;
    @Column(name = "us_size")
    private double us_size;
    @JsonIgnore
    @ManyToMany(mappedBy = "sizes", fetch = FetchType.LAZY)
    private Set<Sneakers> sneakersSet = new HashSet<>();

    @Override
    public String toString() {
        return "Size{" +
                "id=" + id +
                ", eu_size=" + eu_size +
                ", us_size=" + us_size +
                '}';
    }
}
