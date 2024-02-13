package com.example.undercooked.repository;

import com.example.undercooked.model.RecipeGuide;
import com.example.undercooked.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> getRecipeIngredientByRecipe(RecipeGuide recipeGuide);
}
