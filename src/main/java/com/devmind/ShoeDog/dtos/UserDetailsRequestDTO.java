package com.devmind.ShoeDog.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
public class UserDetailsRequestDTO {
    private String email;

    private String firstName;

    private String lastName;

    private String about;

    private String profile_url;
}
