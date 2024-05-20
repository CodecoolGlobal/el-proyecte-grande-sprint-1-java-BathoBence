package com.example.undercooked.service;

import com.example.undercooked.dto.RecipeInfoDTO;
import com.example.undercooked.model.PantryItem;
import com.example.undercooked.model.Recipe;
import com.example.undercooked.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<RecipeInfoDTO> getAllRecipe() {
        List<Recipe> allRecipe = recipeRepository.findAll();
        return getRecipeInfoDTOS(allRecipe);
    }

    public Recipe getRecipeById(long id) {
        return recipeRepository.getRecipeById(id);
    }

    public List<RecipeInfoDTO> getRecipesByUserPantryItems(List<PantryItem> pantryItems) {
        List<String> pantryItemNames = new ArrayList<>();
        for (PantryItem item : pantryItems) {
            pantryItemNames.add(item.getMaterial().getName());
        }
        List<Recipe> recipes = recipeRepository.getRecipesByIngredients(pantryItemNames.toArray(new String[0]));
        return getRecipeInfoDTOS(recipes);
    }

    private List<RecipeInfoDTO> getRecipeInfoDTOS(List<Recipe> recipes) {
        return recipes.stream().map(RecipeInfoDTO::new).toList();
    }


}
