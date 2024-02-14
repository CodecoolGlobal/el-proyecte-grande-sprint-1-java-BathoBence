package com.example.undercooked.dto;

import com.example.undercooked.model.Recipe;

public class RecipeInfoDTO {
    private final long id;
    private final String name;
    private final String description;

    public RecipeInfoDTO(Recipe recipe) {
        this.id = recipe.getId();
        this.name = recipe.getName();
        this.description = recipe.getDescription();
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
