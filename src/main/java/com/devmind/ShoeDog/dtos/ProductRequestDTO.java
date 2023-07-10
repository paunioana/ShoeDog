package com.devmind.ShoeDog.dtos;

import com.devmind.ShoeDog.models.Brand;
import lombok.Data;


@Data
public class ProductRequestDTO {
    private Long id;
    private String model;
    private int year;
    private Long brand;
}
