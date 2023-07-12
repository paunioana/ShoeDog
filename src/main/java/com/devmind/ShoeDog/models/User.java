package com.devmind.ShoeDog.models;

import com.devmind.ShoeDog.security.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
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

    private String profile_url;


    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private Set<Review> user_reviews;

    public void setProfile_url(String profile_url) {
        this.profile_url = profile_url;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Column(name = "subscribed_on")
    @Temporal(TemporalType.DATE)
    private Date subscribedOn;

    public User(String email, String firstName, String lastName, String encode, Role value, Date subscribedOn) {
        this.email = email;
        this.password = encode;
        this.role = value;
        this.firstName = firstName;
        this.lastName = lastName;
        this.about = "";
        this.subscribedOn = subscribedOn;
    }


}
