package com.example.undercooked.controller;

import com.example.undercooked.model.Ingredient;
import com.example.undercooked.service.IngredientProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class IngredientController {
    private final IngredientProvider ingredientProvider;
    @Autowired
    public IngredientController(IngredientProvider ingredientProvider) {
        this.ingredientProvider = ingredientProvider;
    }
    
    @GetMapping("/ingredients")
    public Set<Ingredient> getMain() {
        return null;
    }
    

}
