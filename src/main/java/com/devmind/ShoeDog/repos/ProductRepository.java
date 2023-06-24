package com.devmind.ShoeDog.repos;

import com.devmind.ShoeDog.models.Brand;
import com.devmind.ShoeDog.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.PrimitiveIterator;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByBrandIdOrderByModel(Long brandId);
    Optional<Product> findProductById(Long id);
}
