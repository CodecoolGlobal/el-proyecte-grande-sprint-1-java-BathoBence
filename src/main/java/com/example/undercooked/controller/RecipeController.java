package com.example.undercooked.controller;

import com.example.undercooked.dto.RecipeInfoDTO;
import com.example.undercooked.model.Recipe;
import com.example.undercooked.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RecipeController {

    private RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/main")
    public ResponseEntity<?> getMain() {
        List<Recipe> recipes = recipeService.getAllRecipe();
        System.out.println(recipes.toString());
        return ResponseEntity.ok(recipes);
    }

    @GetMapping("/recipes/byingredients")
    public ResponseEntity<?> getRecipesByIngredient() {
        List<RecipeInfoDTO> recipes = recipeService.getRecipesByIngredients();
        return ResponseEntity.ok(recipes);
    }

    @GetMapping("/recipes/{id}")
    public Recipe getRecipeById(@PathVariable long id){
        return recipeService.getRecipeById(id);
    }

}