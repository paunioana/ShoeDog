package com.devmind.ShoeDog.repos;

import com.devmind.ShoeDog.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Integer countByUserEmail(String email);
    List<Review> findByOrderByProductModel();
    Optional<Review> findReviewById(Long id);
    Optional<Review> deleteReviewById(Long id);

    List<Review> findReviewsByUserEmail(String email);
}
