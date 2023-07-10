package com.devmind.ShoeDog.Services;

import com.devmind.ShoeDog.dtos.ProductRequestDTO;
import com.devmind.ShoeDog.models.Brand;
import com.devmind.ShoeDog.models.Product;
import com.devmind.ShoeDog.models.Review;
import com.devmind.ShoeDog.repos.BrandRepository;
import com.devmind.ShoeDog.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class ProductService {
    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public ResponseEntity<?> addProduct(ProductRequestDTO productRequestDTO, String role) {
        Boolean approved = (role.equals("ADMIN") ? true : false);
        Optional<Product> repo_product = productRepository.findProductByModelAndBrandId(productRequestDTO.getModel(), productRequestDTO.getBrand());
        if(repo_product.isEmpty()) {
            Brand b = brandRepository.getById(productRequestDTO.getBrand());
            Product p = new Product(null, productRequestDTO.getModel(), productRequestDTO.getYear(), b, null, approved);
            productRepository.save(p);
            if(approved) {
                return ResponseEntity.ok("Product added successfully!");
            } else {
                return ResponseEntity.ok("Product added successfully and waiting approval!");
            }
        } else throw new RuntimeException("Product already exists!");

    }

    @Modifying
    public ResponseEntity<?> approveProduct(Long id) {
        Product repo_product = productRepository.findProductById(id).orElseThrow();
        repo_product.setApproved(true);
        productRepository.save(repo_product);
        return ResponseEntity.ok("Product approved!");
    }

    public List<Product> getProductRequests() {
        return productRepository.findProductsByApproved(false);
    }

    @Transactional
    public ResponseEntity<?> deleteProduct(Long id) {
        Product p = productRepository.findProductById(id).orElseThrow();
        return ResponseEntity.ok()
                .body(productRepository.deleteProductById(id));
    }

}
