package com.devmind.ShoeDog.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {
    USER("user"),
    ADMIN("admin");

    private final String role;
}