package com.devmind.ShoeDog.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDTO {
    private String email;
    private String role;
    private String token;

    public LoginResponseDTO(String email, String token, String role) {
        this.email = email;
        this.token = token;
        this.role = role;
    }
}
