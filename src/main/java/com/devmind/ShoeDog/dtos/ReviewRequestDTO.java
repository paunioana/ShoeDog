package com.devmind.ShoeDog.dtos;

import com.devmind.ShoeDog.models.Product;
import com.devmind.ShoeDog.models.User;

import javax.persistence.*;

public class ReviewRequestDTO {
    private Product product;
    private String review_content;
    private String place;
    private int rating;
}
