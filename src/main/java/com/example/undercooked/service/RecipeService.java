package com.example.undercooked.service;

import com.example.undercooked.dto.RecipeInfoDTO;
import com.example.undercooked.model.Recipe;
import com.example.undercooked.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    private RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getAllRecipe() {
        return recipeRepository.findAll();
    }

    public Recipe getRecipeById(long id){
        return recipeRepository.getRecipeById(id);
    }

    public List<RecipeInfoDTO> getRecipesByIngredients() {

        List<Recipe> recipes = recipeRepository.getRecipesByIngredients(
                "Spaghetti", "Large Eggs", "Parmesan Cheese", "Pancetta", "Boneless Chicken Breast",
                "Broccoli", "Soy Sauce");

        return getRecipeInfoDTOS(recipes);
    }

    private List<RecipeInfoDTO> getRecipeInfoDTOS(List<Recipe> recipes) {
        return recipes.stream().map(RecipeInfoDTO::new).toList();
    }


}
