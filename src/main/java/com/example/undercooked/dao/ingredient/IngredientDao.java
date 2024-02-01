package com.example.undercooked.dao.ingredient;

import com.example.undercooked.dao.DbConnector;
import com.example.undercooked.model.Ingredient;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

@Repository
public class IngredientDao implements IngredientDaoInterface {

    private final DbConnector connector;

    public IngredientDao(DbConnector connector) {
        this.connector = connector;
    }

    @Override
        public Set<Ingredient> getAllIngredients() {
        Set<Ingredient> allIngredient = new HashSet<>();
        String query = "SELECT ingredient.id, ingredient.name, food_category.name AS food_category FROM ingredient JOIN food_category ON ingredient.food_category = food_category.id";
        try (Connection connection = connector.getConnection();
             PreparedStatement pstm = connection.prepareStatement(query);
             ResultSet rs = pstm.executeQuery()) {
            while (rs.next()) {
                Ingredient ingredient = new Ingredient(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("food_category"));
                allIngredient.add(ingredient);
                System.out.println(ingredient.toString());
            }

            return allIngredient;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
