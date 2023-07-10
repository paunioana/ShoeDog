package com.devmind.ShoeDog.controllers;

import com.devmind.ShoeDog.Services.ProductService;
import com.devmind.ShoeDog.Services.ReviewService;
import com.devmind.ShoeDog.dtos.ProductRequestDTO;
import com.devmind.ShoeDog.dtos.ReviewRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private ProductService productService;

    @GetMapping("/brands")
    @CrossOrigin
    public ResponseEntity<?> getAllBrands() {
        return ResponseEntity.ok()
                .body(reviewService.getAllBrands());
    }

    @GetMapping("/products")
    @CrossOrigin
    public ResponseEntity<?> getProductsByBrand(@RequestParam Long brandId) {
        return reviewService.getProductsByBrand(brandId);
    }
    @PostMapping("/addModel")
    @CrossOrigin
    public ResponseEntity<?> addModel(@RequestBody ProductRequestDTO productRequestDTO, @RequestParam String role) {
        return productService.addProduct(productRequestDTO, role);
    }
    @PostMapping("/addReview")
    @CrossOrigin
    public ResponseEntity<?> addReview(@RequestBody ReviewRequestDTO reviewRequestDTO, @RequestParam String email) {
        return reviewService.addReview(reviewRequestDTO, email);
    }

    @GetMapping("/all")
    @CrossOrigin
    public ResponseEntity<?> getAllReviews() {
        return ResponseEntity.ok()
                .body(reviewService.getAllReviews());
    }

    @GetMapping("/myReviews")
    @CrossOrigin
    public ResponseEntity<?> getUserReviews(@RequestParam String email) {
        return ResponseEntity.ok()
                .body(reviewService.getUserReviews(email));
    }



}

