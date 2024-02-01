package com.example.undercooked.dao.ingredient;

import com.example.undercooked.dao.DbConnector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientDaoTest {

    @Test
    void getAllIngredients() {
        DbConnector connector = new DbConnector();
        IngredientDao ingredientDao = new IngredientDao(connector);
        ingredientDao.getAllIngredients();
    }
}