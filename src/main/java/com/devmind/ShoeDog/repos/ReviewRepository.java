package com.devmind.ShoeDog.repos;

import com.devmind.ShoeDog.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Integer countByUserEmail(String email);
}
