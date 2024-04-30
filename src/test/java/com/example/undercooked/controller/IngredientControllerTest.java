package com.example.undercooked.controller;

import com.example.undercooked.model.FoodCategory;
import com.example.undercooked.model.IngredientMaterial;
import com.example.undercooked.service.IngredientProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class IngredientControllerTest {

    @Mock
    private IngredientProvider ingredientProvider;

    @InjectMocks
    private IngredientController ingredientController;

    @Test
    void testGetAllIngredient_Success() {
        List<IngredientMaterial> ingredients = new ArrayList<>();

        FoodCategory pasta = new FoodCategory("pasta");
        FoodCategory dairy = new FoodCategory("dairy");

        ingredients.add(new IngredientMaterial("Spaghetti", pasta));
        ingredients.add(new IngredientMaterial("Milk", dairy));

        Mockito.when(ingredientProvider.getAllIngredients()).thenReturn(ingredients);

        List<IngredientMaterial> result = ingredientController.getAllIngredient();

        assertEquals(ingredients, result);
    }

    @Test
    void testGetAllIngredient_EmptyList() {

        Mockito.when(ingredientProvider.getAllIngredients()).thenReturn(new ArrayList<>());

        List<IngredientMaterial> result = ingredientProvider.getAllIngredients();

        assertTrue(result.isEmpty());
    }

}