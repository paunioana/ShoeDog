package com.devmind.ShoeDog.Services;

import com.devmind.ShoeDog.dtos.ProductRequestDTO;
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
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    public List<Brand> getAllBrands() {
        return brandRepository.findByOrderByName();
    }

    public List<Product> getProductsByBrand(Long brandId) {
        return productRepository.findAllByBrandIdAndApprovedOrderByModel(brandId, true);
    }


    public List<Review> getAllReviews() {
        return reviewRepository.findByOrderByProductModel();
    }

    public List<Review> getUserReviews(String email) {
        return reviewRepository.findReviewsByUserEmail(email);
    }

    @Transactional
    public ResponseEntity<?> deleteReview(Long reviewId) {
        Review rev = reviewRepository.findReviewById(reviewId).orElseThrow();
        return ResponseEntity.ok()
                .body(reviewRepository.deleteReviewById(reviewId));
    }

    @Transactional
    public String addReview(ReviewRequestDTO reviewRequestDTO, String email) {
        User user = userRepository.findUserByEmail(email).orElseThrow();
        System.out.println(user);
        Product repo_product = productRepository.findProductById(reviewRequestDTO.getProduct()).orElseThrow();

        Review review = new Review(null,repo_product, user,reviewRequestDTO.getReview_content(), reviewRequestDTO.getPurchase_place(), reviewRequestDTO.getRating(), new Date());
        reviewRepository.save(review);
        return "Review added successfully!";
    }

}
