package com.example.undercooked.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pantry {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

}
