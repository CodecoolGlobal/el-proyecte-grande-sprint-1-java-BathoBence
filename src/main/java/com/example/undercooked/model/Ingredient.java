package com.example.undercooked.model;

import jakarta.persistence.*;

@Entity
public class Ingredient{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(unique = true)
    private String name;
    @ManyToOne
    @JoinColumn(name = "food_category_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_ingredient_foodcategory"))
    private FoodCategory foodCategory;

    public Ingredient(String name, FoodCategory foodCategory) {
        this.name = name;
        this.foodCategory = foodCategory;
    }

    public Ingredient() {
    }

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public FoodCategory getFoodCategory() {
        return foodCategory;
    }
}
