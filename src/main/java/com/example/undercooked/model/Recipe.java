package com.example.undercooked.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CollectionType;

import java.util.List;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToOne
    @JoinColumn(name = "recipe_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_recipeingredient_recipe"))
    private RecipeGuide recipeGuide;

    @ManyToOne
    @JoinColumn(name = "ingredienty_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_recipeingredient_ingredient"))
    private Ingredient ingredient;

    private List<IngredientTest> ingredientList;
    private double amount;
    private String unit;

    public Recipe(RecipeGuide recipeGuide, Ingredient ingredient, double amount, String unit) {
        this.recipeGuide = recipeGuide;
        this.ingredient = ingredient;
        this.amount = amount;
        this.unit = unit;
    }

    public Recipe() {
    }

    public long getId() {
        return id;
    }

    public RecipeGuide getRecipe() {
        return recipeGuide;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public double getAmount() {
        return amount;
    }

    public String getUnit() {
        return unit;
    }
}
