package com.devmind.ShoeDog.models;

import com.devmind.ShoeDog.security.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;


@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @NotEmpty
    @Id
    private String email;

    private String firstName;

    private String lastName;
    private String about;
    @JsonIgnore
    @ToString.Exclude
    private String password;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private Set<Review> user_reviews;

    public User(String email, String firstName, String lastName, String encode, Role value) {
        this.email = email;
        this.password = encode;
        this.role = value;
        this.firstName = firstName;
        this.lastName = lastName;
        this.about = "";
    }

}
