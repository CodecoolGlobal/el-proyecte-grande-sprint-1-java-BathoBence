package com.example.undercooked.model;

import jakarta.persistence.*;

@Entity
public class IngredientMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "food_category_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_ingredientmaterial_foodcategory"))
    private FoodCategory foodCategory;

    public IngredientMaterial() {

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
