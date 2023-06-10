package com.devmind.ShoeDog.models;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String model;
    int year;
    String season;

    @ManyToOne
    @JoinColumn(name = "id_brand")
    public Brand brand;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    public Set<Review> productReviews;



}
