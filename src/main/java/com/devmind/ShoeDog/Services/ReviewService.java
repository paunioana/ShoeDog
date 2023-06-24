package com.devmind.ShoeDog.Services;

import com.devmind.ShoeDog.dtos.LoginResponseDTO;
import com.devmind.ShoeDog.dtos.ReviewRequestDTO;
import com.devmind.ShoeDog.models.Brand;
import com.devmind.ShoeDog.models.Product;
import com.devmind.ShoeDog.models.Review;
import com.devmind.ShoeDog.models.User;
import com.devmind.ShoeDog.repos.BrandRepository;
import com.devmind.ShoeDog.repos.ProductRepository;
import com.devmind.ShoeDog.repos.ReviewRepository;
import com.devmind.ShoeDog.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    public ResponseEntity<?> getAllBrands() {
        return ResponseEntity.ok()
                .body(brandRepository.findByOrderByName());
    }

    public ResponseEntity<?> getProductsByBrand(Long brandId) {
        return ResponseEntity.ok()
                .body(productRepository.findAllByBrandIdOrderByModel(brandId));
    }

    public ResponseEntity<?>  addReview(ReviewRequestDTO reviewRequestDTO, String email) {
        User user = userRepository.findUserByEmail(email).orElseThrow();
        System.out.println(user);
        Product repo_product = productRepository.findProductById(reviewRequestDTO.getProduct()).orElseThrow();

        Review review = new Review(null,repo_product, user,reviewRequestDTO.getReview_content(), reviewRequestDTO.getPurchase_place(), reviewRequestDTO.getRating());
        return ResponseEntity.ok()
                .body(reviewRepository.save(review));
    }


}
