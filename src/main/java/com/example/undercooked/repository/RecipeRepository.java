package com.example.undercooked.repository;

import com.example.undercooked.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Recipe getRecipeById(long id);

    @Query(value = "WITH recipe_materials AS (\n" +
            "SELECT r.id, COUNT(im.id) AS material_count FROM recipe r\n" +
            "JOIN recipe_ingredients ri ON r.id = ri.recipe_id\n" +
            "JOIN ingredient i ON ri.ingredients_id = i.id\n" +
            "JOIN ingredient_material im ON i.ingredientmaterial_id = im.id \n" +
            "group by r.id)\n" +
            "\n" +
            "SELECT r.name AS \"name\", r.id AS \"id\", r.description AS \"description\"" +
            "FROM recipe r\n" +
            "JOIN recipe_ingredients ri ON r.id = ri.recipe_id\n" +
            "JOIN ingredient i ON ri.ingredients_id = i.id\n" +
            "JOIN ingredient_material im ON i.ingredientmaterial_id = im.id\n" +
            "JOIN recipe_materials rm ON r.id = rm.id\n" +
            "WHERE im.name IN (:#{#ingredients})\n" +
            "GROUP BY r.id, r.name, rm.material_count, recipe_id\n" +
            "HAVING COUNT(DISTINCT im.name) = rm.material_count",
            nativeQuery = true)

    List<Recipe> getRecipesByIngredients(@Param("ingredients") String... ingredients);
}
