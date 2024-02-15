package com.example.undercooked.controller;

import com.example.undercooked.dto.RecipeInfoDTO;
import com.example.undercooked.model.Recipe;
import com.example.undercooked.service.RecipeServie;
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

    @GetMapping("/recipes/byingredients")
    public ResponseEntity<?> getRecipesByIngredient() {
        List<RecipeInfoDTO> recipes = recipeServie.getRecipesByIngredients();
        return ResponseEntity.ok(recipes);
    }

    @GetMapping("/recipes/{id}")
    public Recipe getRecipeById(@PathVariable long id){
        return recipeServie.getRecipeById(id);
    }

}