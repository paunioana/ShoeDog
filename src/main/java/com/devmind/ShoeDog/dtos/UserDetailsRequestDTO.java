package com.devmind.ShoeDog.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDetailsRequestDTO {
    private String email;

    private String firstName;

    private String lastName;

    private Integer no_reviews;
    private String about;
}
