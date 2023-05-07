package com.devmind.ShoeDog.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "reviews")
@Data
public class Review {
    @Id
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
