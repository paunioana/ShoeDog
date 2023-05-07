package com.devmind.ShoeDog.models;

public enum Season {
    FW("Fall/Winter"),
    SS("Spring/Summer");
    public final String label;

    private Season(String label) {
        this.label = label;
    }
}


