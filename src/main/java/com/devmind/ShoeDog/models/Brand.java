package com.devmind.ShoeDog.models;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "brands")
@Data
public class Brand {

    @Id
    Integer id;
    String name;
    @OneToMany(mappedBy = "brand")
    public Set<Product> createdProducts;

}
