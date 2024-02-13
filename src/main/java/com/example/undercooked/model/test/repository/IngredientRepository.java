package com.example.undercooked.model.test.repository;

import com.example.undercooked.model.test.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
