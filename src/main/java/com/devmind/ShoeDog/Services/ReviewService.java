package com.devmind.ShoeDog.Services;

import com.devmind.ShoeDog.dtos.LoginResponseDTO;
import com.devmind.ShoeDog.models.Brand;
import com.devmind.ShoeDog.models.Product;
import com.devmind.ShoeDog.repos.BrandRepository;
import com.devmind.ShoeDog.repos.ProductRepository;
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
    public ResponseEntity<?> getAllBrands() {
        return ResponseEntity.ok()
                .body(brandRepository.findByOrderByName());
    }

    public ResponseEntity<?> getProductsByBrand(Integer brandId) {
        return ResponseEntity.ok()
                .body(productRepository.findAllByBrandIdOrderByModel(brandId));
    }


}
