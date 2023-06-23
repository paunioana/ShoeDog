package com.devmind.ShoeDog.models;

import javax.persistence.*;
import lombok.Data;


@Entity
@Table(name = "reviews")
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @ManyToOne
    @JoinColumn(name = "id_product")
    public Product product;
    @ManyToOne
    @JoinColumn(name = "id_user")
    public User user;
    String review_content;
    String place;
    int rating;

}
