package com.example.undercooked.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    private Set<Role> roles;
    @OneToMany
    private List<Ingredient> ingredients;

    public UserEntity(String name, String emailAddress, String password) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.password = password;
        this.ingredients = new ArrayList<>();
        this.roles = new HashSet<>();
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

    public Set<Role> getRoles() {
        return new HashSet<>(roles);
    }

    public String getPassword() {
        return password;
    }

    public boolean add(Role role) {
        return roles.add(role);
    }

    public List<Ingredient> getPantry() {
        return new ArrayList<>(ingredients);
    }
}
