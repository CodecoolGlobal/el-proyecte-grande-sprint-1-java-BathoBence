-- Delete all data from the recipe_ingredients table
DELETE FROM recipe_ingredients;

-- Delete all data from the recipe table
DELETE FROM recipe;

-- Delete all data from the ingredient table
DELETE FROM ingredient;

-- Delete all data from the ingredient_material table
DELETE FROM ingredient_material;

-- Delete all data from the food_category table
DELETE FROM food_category;

-- Insert data into the food_category table
INSERT INTO food_category (id, "name") VALUES
                                         (1, 'Pasta'),
                                         (2, 'Eggs'),
                                         (3, 'Cheese'),
                                         (4, 'Pancetta'),
                                         (5, 'Chicken'),
                                         (6, 'Vegetables'),
                                         (7, 'Soy Sauce'),
                                         (8, 'Tomatoes'),
                                         (9, 'Mozzarella'),
                                         (10, 'Basil'),
                                         (11, 'Balsamic Vinegar'),
                                         (12, 'Salmon'),
                                         (13, 'Lemon'),
                                         (14, 'Herbs'),
                                         (15, 'Curry Powder'),
                                         (16, 'Rice');

-- Insert data into the ingredient_material table
INSERT INTO ingredient_material (food_category_id, id, name) VALUES
-- Example data
(1, 1, 'Spaghetti'),
(1, 2, 'Fettuccine'),
(2, 3, 'Large Eggs'),
(2, 4, 'Medium Eggs'),
(3, 5, 'Parmesan Cheese'),
(3, 6, 'Cheddar Cheese'),
(4, 7, 'Bacon'),
(4, 8, 'Pancetta'),
(5, 9, 'Boneless Chicken Breast'),
(5, 10, 'Chicken Thighs'),
(6, 11, 'Broccoli'),
(6, 12, 'Bell Pepper'),
(7, 13, 'Soy Sauce'),
(7, 14, 'Teriyaki Sauce'),
(8, 15, 'Roma Tomatoes'),
(8, 16, 'Cherry Tomatoes'),
(9, 17, 'Fresh Mozzarella'),
(9, 18, 'Shredded Mozzarella'),
(10, 19, 'Fresh Basil'),
(10, 20, 'Dried Basil'),
(11, 21, 'Traditional Balsamic Vinegar'),
(11, 22, 'Balsamic Glaze'),
(12, 23, 'Atlantic Salmon'),
(12, 24, 'Sockeye Salmon'),
(13, 25, 'Fresh Lemon'),
(13, 26, 'Lemon Juice'),
(14, 27, 'Fresh Herbs'),
(14, 28, 'Dried Herbs'),
(15, 29, 'Yellow Curry Powder'),
(15, 30, 'Red Curry Paste'),
(16, 31, 'White Rice'),
(16, 32, 'Brown Rice');

-- Insert data into the recipe table
INSERT INTO recipe (id, name, description) VALUES
                                           (1, 'Spaghetti Carbonara', 'Classic Italian pasta dish with eggs, cheese, and pancetta.'),
                                           (2, 'Chicken Stir-Fry', 'Quick and easy stir-fry with chicken, vegetables, and soy sauce.'),
                                           (3, 'Caprese Salad', 'Refreshing salad made with tomatoes, mozzarella, basil, and balsamic vinegar.'),
                                           (4, 'Grilled Salmon', 'Healthy and flavorful grilled salmon seasoned with lemon and herbs.'),
                                           (5, 'Vegetable Curry', 'Vegetarian curry packed with colorful vegetables and aromatic spices.');

-- Insert data into the ingredient table
INSERT INTO ingredient (id, amount, ingredientmaterial_id, unit) VALUES
-- Example data
(1, 200, 1, 'grams'), -- 200 grams of Spaghetti
(2, 3, 3, 'pieces'), -- 3 large eggs
(3, 100, 5, 'grams'), -- 100 grams of Parmesan Cheese
(4, 150, 8, 'grams'), -- 150 grams of Pancetta
(5, 300, 9, 'grams'), -- 300 grams of Boneless Chicken Breast
(6, 200, 11, 'grams'), -- 200 grams of Broccoli
(7, 50, 13, 'ml'), -- 50 ml of Soy Sauce
(8, 4, 15, 'pieces'), -- 4 Roma Tomatoes
(9, 200, 17, 'grams'), -- 200 grams of Fresh Mozzarella
(10, 20, 19, 'grams'), -- 20 grams of Fresh Basil
(11, 1, 21, 'tablespoon'), -- 1 tablespoon of Traditional Balsamic Vinegar
(12, 300, 23, 'grams'), -- 300 grams of Atlantic Salmon
(13, 1, 25, 'piece'), -- 1 Fresh Lemon
(14, 15, 27, 'grams'), -- 15 grams of Fresh Herbs
(15, 2, 29, 'tablespoons'), -- 2 tablespoons of Yellow Curry Powder
(16, 3, 29, 'tablespoons'), -- 2 tablespoons of Yellow Curry Powder
(17, 4, 29, 'tablespoons'); -- 2 tablespoons of Yellow Curry Powder


-- Insert data into the recipe_ingredients table
INSERT INTO recipe_ingredients (recipe_id, ingredients_id) VALUES
-- Example data
(1, 1), -- Spaghetti Carbonara with Spaghetti
(1, 2), -- Spaghetti Carbonara with Large Eggs
(1, 3), -- Spaghetti Carbonara with Parmesan Cheese
(1, 4), -- Spaghetti Carbonara with Pancetta
(2, 5), -- Chicken Stir-Fry with Boneless Chicken Breast
(2, 6), -- Chicken Stir-Fry with Broccoli
(2, 7), -- Chicken Stir-Fry with Soy Sauce
(3, 8), -- Caprese Salad with Roma Tomatoes
(3, 9), -- Caprese Salad with Fresh Mozzarella
(3, 10), -- Caprese Salad with Fresh Basil
(3, 11), -- Caprese Salad with Traditional Balsamic Vinegar
(4, 12), -- Grilled Salmon with Atlantic Salmon
(4, 13), -- Grilled Salmon with Fresh Lemon
(4, 14), -- Grilled Salmon with Fresh Herbs
(5, 15), -- Vegetable Curry with Yellow Curry Powder
(4, 16), -- Vegetable Curry with Yellow Curry Powder
(3, 17); -- Vegetable Curry with Yellow Curry Powder
