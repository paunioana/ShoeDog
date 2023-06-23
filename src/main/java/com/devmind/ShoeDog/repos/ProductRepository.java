package com.devmind.ShoeDog.repos;

import com.devmind.ShoeDog.models.Brand;
import com.devmind.ShoeDog.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.PrimitiveIterator;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByBrandIdOrderByModel(Integer brandId);
}
