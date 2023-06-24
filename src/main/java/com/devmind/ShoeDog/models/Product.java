package com.devmind.ShoeDog.models;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String model;
    private int year;

    @ManyToOne
    @JoinColumn(name = "id_brand")
    private Brand brand;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private Set<Review> productReviews;



}
