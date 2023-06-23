package com.devmind.ShoeDog.models;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "brands")
@Data
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String name;
    @OneToMany(mappedBy = "brand")
    @JsonIgnore
    public Set<Product> createdProducts;

}
