package com.devmind.ShoeDog.controllers;

import com.devmind.ShoeDog.Services.ReviewService;
import com.devmind.ShoeDog.Services.UserService;
import com.devmind.ShoeDog.dtos.LoginRequestDTO;
import com.devmind.ShoeDog.dtos.RegisterRequestDTO;
import com.devmind.ShoeDog.models.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {
    @Autowired
    private UserService userService;
    @Autowired
    private ReviewService reviewService;


    @PostMapping("/user/review")
    @CrossOrigin
    public ResponseEntity<?> addReview(@RequestBody LoginRequestDTO loginRequest) {
        return userService.login(loginRequest);
    }

    @PostMapping("/review/register")
    @CrossOrigin
    public ResponseEntity<?> getAllReviews(@RequestBody RegisterRequestDTO registerRequestDTO) {
        return userService.register(registerRequestDTO);
    }

    @GetMapping("/brands")
    @CrossOrigin
    public ResponseEntity<?> getAllBrands() {
        return reviewService.getAllBrands();
    }

    @GetMapping("/products")
    @CrossOrigin
    public ResponseEntity<?> getProductsByBrand(@RequestParam Integer brandId) {
        return reviewService.getProductsByBrand(brandId);
    }


}

