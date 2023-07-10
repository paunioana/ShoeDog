package com.devmind.ShoeDog.controllers;

import com.devmind.ShoeDog.Services.ProductService;
import com.devmind.ShoeDog.Services.ReviewService;
import com.devmind.ShoeDog.dtos.ProductRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private ProductService productService;

    @DeleteMapping("/deleteReview")
    @CrossOrigin
    public ResponseEntity<?> deleteReview(@RequestParam String reviewId) {
        return ResponseEntity.ok()
                .body(reviewService.deleteReview(Long.parseLong(reviewId)));
    }

    @DeleteMapping("/deleteProduct")
    @CrossOrigin
    public ResponseEntity<?> deleteProduct(@RequestParam String id) {
        return ResponseEntity.ok()
                .body(productService.deleteProduct(Long.parseLong(id)));
    }

    @PostMapping("/approveProduct")
    @CrossOrigin
    public ResponseEntity<?> approveProduct(@RequestParam String id) {
        return productService.approveProduct(Long.parseLong(id));
    }

    @GetMapping("/requests")
    @CrossOrigin
    public ResponseEntity<?> getRequests() {
        return ResponseEntity.ok()
                .body(productService.getProductRequests());
    }
}
