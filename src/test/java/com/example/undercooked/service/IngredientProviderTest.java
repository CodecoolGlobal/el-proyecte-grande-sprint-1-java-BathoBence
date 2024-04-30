package com.example.undercooked.service;

import com.example.undercooked.model.FoodCategory;
import com.example.undercooked.model.IngredientMaterial;
import com.example.undercooked.repository.IngredientMaterialRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class IngredientProviderTest {

    @Mock
    private IngredientMaterialRepository ingredientMaterialRepository;
    @InjectMocks
    private IngredientProvider ingredientProvider;

    @Test
    void testGetAllIngredients_Success() {
        List<IngredientMaterial> ingredients = new ArrayList<>();

        FoodCategory pasta = new FoodCategory("pasta");
        FoodCategory dairy = new FoodCategory("dairy");

        ingredients.add(new IngredientMaterial("Milk", dairy));
        ingredients.add(new IngredientMaterial("Spaghetti", pasta));

        Mockito.when(ingredientMaterialRepository.findAll()).thenReturn(ingredients);

        List<IngredientMaterial> result = ingredientProvider.getAllIngredients();

        assertEquals(ingredients, result);
    }
}