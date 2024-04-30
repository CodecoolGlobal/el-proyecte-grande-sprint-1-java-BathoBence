package com.example.undercooked.service;

import com.example.undercooked.model.IngredientMaterial;
import com.example.undercooked.repository.IngredientMaterialRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class IngredientProvider {

    private final IngredientMaterialRepository ingredientMaterialRepository;

    public IngredientProvider(IngredientMaterialRepository ingredientMaterialRepository) {
        this.ingredientMaterialRepository = ingredientMaterialRepository;
    }

    public List<IngredientMaterial> getAllIngredients() {
        return ingredientMaterialRepository.findAll().stream()
                .sorted(Comparator.comparing(IngredientMaterial::getName))
                .toList();
    }

}
