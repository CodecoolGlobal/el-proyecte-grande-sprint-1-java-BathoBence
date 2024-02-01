package com.example.undercooked.controller;

import com.example.undercooked.service.IngredientProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IngredientController {

    private final IngredientProvider ingredientProvider;

    @Autowired
    public IngredientController(IngredientProvider ingredientProvider) {
        this.ingredientProvider = ingredientProvider;
    }

    @GetMapping("/ingredients")
    public ResponseEntity<?> getMain() {
        return ResponseEntity.ok(ingredientProvider.getAllIngredients());
    }
}
