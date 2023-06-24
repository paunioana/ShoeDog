package com.devmind.ShoeDog.controllers;

import com.devmind.ShoeDog.Services.ReviewService;
import com.devmind.ShoeDog.Services.UserService;
import com.devmind.ShoeDog.dtos.LoginRequestDTO;
import com.devmind.ShoeDog.dtos.RegisterRequestDTO;
import com.devmind.ShoeDog.dtos.ReviewRequestDTO;
import com.devmind.ShoeDog.models.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private UserService userService;
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/brands")
    @CrossOrigin
    public ResponseEntity<?> getAllBrands() {
        return reviewService.getAllBrands();
    }

    @GetMapping("/products")
    @CrossOrigin
    public ResponseEntity<?> getProductsByBrand(@RequestParam Long brandId) {
        return reviewService.getProductsByBrand(brandId);
    }

    @PostMapping("/addReview")
    @CrossOrigin
    public ResponseEntity<?> addReview(@RequestBody ReviewRequestDTO reviewRequestDTO, @RequestParam String email) {
        return reviewService.addReview(reviewRequestDTO, email);
    }


}

