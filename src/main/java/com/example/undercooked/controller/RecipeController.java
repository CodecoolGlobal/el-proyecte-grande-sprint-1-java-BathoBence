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

/*
 * GET /api/recipies <-- List all
 * GET /api/recipies/:id <-- get one
 * POST /api/recipies <-- add
 * PATCH /api/recipies/:id <-- update one
 * DELETE /api/recipies/:id <-- delete one
 * 
 */

@RestController
@RequestMapping("/api/recipies")
public class RecipeController {

    private RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getMain() {
        List<RecipeInfoDTO> recipes = recipeService.getAllRecipe();
        return ResponseEntity.ok(recipes);
    }

    @GetMapping("/recipes/byingredients")
    public ResponseEntity<?> getRecipesByIngredient() {
        List<RecipeInfoDTO> recipes = recipeService.getRecipesByIngredients();
        return ResponseEntity.ok(recipes);
    }

    @GetMapping("/{id}")
    public Recipe getRecipeById(@PathVariable long id){
        return recipeService.getRecipeById(id);
    }

}