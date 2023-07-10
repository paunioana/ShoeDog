package com.devmind.ShoeDog.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
@Data
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
    @JsonBackReference
    private Set<Review> productReviews;

    private Boolean approved;


}
