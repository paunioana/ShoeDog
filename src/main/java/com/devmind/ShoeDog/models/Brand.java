package com.devmind.ShoeDog.models;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "brands")
@Data
public class Brand {

    Integer id;
    String name;
    @OneToMany(mappedBy = "brand")
    public Set<Product> createdProducts;

}
