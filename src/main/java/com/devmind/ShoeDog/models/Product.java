package com.devmind.ShoeDog.models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    Integer id;
    String model;
    int year;
    String season;

    @ManyToOne
    @JoinColumn(name = "id_brand")
    public Brand brand;

    @OneToMany(mappedBy = "review")
    public Set<Review> productReviews;



}
