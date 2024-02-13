package com.example.undercooked.model;

public class IngredientTest {
    private Ingredient ingredient;
    private double amount;
    private String unit;

    public IngredientTest(Ingredient ingredient, double amount, String unit) {
        this.ingredient = ingredient;
        this.amount = amount;
        this.unit = unit;
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
