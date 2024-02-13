package com.example.undercooked.model;

import jakarta.persistence.*;

@Entity
public class FoodCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(unique = true)
    private String name;

    public FoodCategory(String name) {
        this.name = name;
    }

    public FoodCategory() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
