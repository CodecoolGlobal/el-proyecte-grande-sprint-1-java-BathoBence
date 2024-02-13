package com.example.undercooked.model;

import jakarta.persistence.*;

@Entity
public class RecipeGuide {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String description;

    public RecipeGuide(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public RecipeGuide() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

