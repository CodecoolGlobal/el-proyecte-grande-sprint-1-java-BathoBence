package com.example.undercooked.repository;

import com.example.undercooked.model.FoodCategory;
import com.example.undercooked.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    Optional<Ingredient> getIngredientByFoodCategory(FoodCategory foodCategory);
    List<Ingredient> findAll();

}
