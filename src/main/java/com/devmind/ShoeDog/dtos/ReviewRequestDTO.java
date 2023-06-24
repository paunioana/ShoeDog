package com.devmind.ShoeDog.dtos;

import lombok.Data;

@Data
public class ReviewRequestDTO {
    private Long product;
    private Long brand;
    private String review_content;
    private String purchase_place;
    private String rating;
}
