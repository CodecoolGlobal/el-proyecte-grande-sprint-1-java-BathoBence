package com.example.undercooked.model;

import jakarta.persistence.*;

@Entity
public class PantryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToOne
    @JoinColumn(name = "ingredientmaterial_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_pantryitem_ingredientmaterial"))
    private IngredientMaterial material;
    private double amount;
    private String unit;

    public PantryItem(IngredientMaterial material, double amount, String unit) {
        this.material = material;
        this.amount = amount;
        this.unit = unit;
    }

    public PantryItem() {

    }

    public IngredientMaterial getMaterial() {
        return material;
    }

    public double getAmount() {
        return amount;
    }

    public String getUnit() {
        return unit;
    }
}
