package com.example.undercooked.service;

import com.example.undercooked.model.Recipe;
import com.example.undercooked.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServie {

    private RecipeRepository recipeRepository;

    public RecipeServie(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getAllRecipe() {
        return recipeRepository.findAll();
    }

    public Recipe getRecipeById(long id){
        return recipeRepository.getRecipeById(id);
    }

    public List<Recipe> getRecipiesByIngredients() {

        return recipeRepository.getRecipesByIngredients("Spaghetti", "Large Eggs", "Parmesan Cheese", "Pancetta",
                "Boneless Chicken Breast",
                "Broccoli",
                "Soy Sauce");
    }

}
