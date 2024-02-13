package com.example.undercooked.service;

import com.example.undercooked.model.Ingredient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class IngredientProvider {

    private static final Logger logger = LoggerFactory.getLogger(IngredientProvider.class);

    public IngredientProvider() {
    }
    public Set<Ingredient> getAllIngredients() {
        return null;
    }

}
