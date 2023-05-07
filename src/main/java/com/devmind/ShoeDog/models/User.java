package com.devmind.ShoeDog.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;


@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    Integer id;
    String email;
    String password;
    String username;
    String role;

    @OneToMany(mappedBy = "review")
    public Set<Review> user_reviews;
}
