package com.devmind.ShoeDog.controllers;

import com.devmind.ShoeDog.Services.UserService;
import com.devmind.ShoeDog.dtos.LoginRequestDTO;
import com.devmind.ShoeDog.dtos.LoginResponseDTO;
import com.devmind.ShoeDog.dtos.RegisterRequestDTO;
import com.devmind.ShoeDog.dtos.UserDetailsRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @CrossOrigin
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequest) {
        return userService.login(loginRequest);
    }

    @PostMapping("/register")
    @CrossOrigin
    public ResponseEntity<?> register(@RequestBody RegisterRequestDTO registerRequestDTO) {
        return userService.register(registerRequestDTO);
    }

    @GetMapping("/details")
    @CrossOrigin
    public ResponseEntity<?> getUserDetails(@RequestParam String email) {
        return ResponseEntity.ok()
                .body(userService.getUserDetails(email));
    }

    @PostMapping("/update")
    @CrossOrigin
    public ResponseEntity<?> updateUSerDetails(@RequestBody UserDetailsRequestDTO userDetailsRequestDTO) {
        return ResponseEntity.ok()
                .body(userService.updateUserDetails(userDetailsRequestDTO));
    }
}
