package com.example.undercooked.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String description;
    @Column(columnDefinition = "TEXT")
    private String guide;
    //need lazy something,
    @OneToMany
    private List<Ingredient> ingredients;

    public Recipe(String description, String name, String guide) {
        this.description = description;
        this.name = name;
        this.guide = guide;
    }

    public Recipe() {
    }

    public boolean add(Ingredient ingredient) {
        return ingredients.add(ingredient);
    }

    public List<Ingredient> getIngredients() {
        return new ArrayList<>(ingredients);
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

    public String getGuide() {
        return guide;
    }
}
