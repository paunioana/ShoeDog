package com.devmind.ShoeDog.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;



@Entity
@Table(name = "reviews")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_product")
    @JsonManagedReference
    private Product product;
    @ManyToOne
    @JoinColumn(name = "user_email")
    @JsonManagedReference
    private User user;
    private String review_content;
    private String place;
    private String rating;
    @Column(name = "published_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date publishedOn;

}
