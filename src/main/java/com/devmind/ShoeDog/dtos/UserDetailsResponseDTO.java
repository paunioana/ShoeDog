package com.devmind.ShoeDog.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
public class UserDetailsResponseDTO {
    private String email;

    private String firstName;

    private String lastName;

    private Integer no_reviews;
    private String about;

    private String profile_url;
}
