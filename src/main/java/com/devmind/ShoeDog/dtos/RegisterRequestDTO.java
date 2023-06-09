package com.devmind.ShoeDog.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequestDTO {
    private String email;

    private String firstName;

    private String lastName;
    private String role;
    private String password;
}
