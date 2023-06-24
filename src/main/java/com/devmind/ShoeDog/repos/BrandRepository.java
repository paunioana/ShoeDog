package com.devmind.ShoeDog.repos;

import com.devmind.ShoeDog.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Long> {

    List<Brand> findByOrderByName();


}
