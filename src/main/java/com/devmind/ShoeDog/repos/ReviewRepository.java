package com.devmind.ShoeDog.repos;

import com.devmind.ShoeDog.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
