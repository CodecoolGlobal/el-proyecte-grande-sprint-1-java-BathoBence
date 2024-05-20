package com.example.undercooked.model.user;

import com.example.undercooked.model.PantryItem;
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
    private List<PantryItem> pantryItems;

    public UserEntity(String name, String emailAddress, String password) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.password = password;
        this.pantryItems = new ArrayList<>();
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

    public boolean addRole(Role role) {
        return roles.add(role);
    }

    public List<PantryItem> getPantry() {
        return new ArrayList<>(this.pantryItems);
    }

    public boolean addPantryItem(PantryItem pantryItem) {
        return pantryItems.add(pantryItem);
    }
}
