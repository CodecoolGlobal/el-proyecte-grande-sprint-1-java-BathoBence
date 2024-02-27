package com.example.undercooked.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String emailAddress;
    @Column(nullable = false)
    private String password;
    @OneToMany
    private List<Ingredient> ingredients;

    public UserEntity(String name, String emailAddress, String password) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.password = password;
        this.ingredients = new ArrayList<>();
    }

    public UserEntity() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public List<Ingredient> getPantry() {
        return new ArrayList<>(ingredients);
    }
}
