package com.example.undercooked.controller;

import com.example.undercooked.model.Recipe;
import com.example.undercooked.service.RecipeServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RecipeController {

    private RecipeServie recipeServie;

    @Autowired
    public RecipeController(RecipeServie recipeServie) {
        this.recipeServie = recipeServie;
    }

    @GetMapping("/main")
    public ResponseEntity<?> getMain() {
        List<Recipe> recipes = recipeServie.getAllRecipe();
        System.out.println(recipes.toString());
        return ResponseEntity.ok(recipes);
    }

    @GetMapping("/cica")
    public ResponseEntity<?> getRecipesByIngredient() {
        List<Recipe> recipes = recipeServie.getRecipiesByIngredients();
        return ResponseEntity.ok(recipes);
    }

}