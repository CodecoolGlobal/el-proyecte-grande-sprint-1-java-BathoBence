INSERT INTO recipe_ingredient(id,recipe_id,ingredient_id,amount, unit)
VALUES (DEFAULT, (SELECT id FROM recipe WHERE name='Paprikás krumpli'), (SELECT id FROM ingredient WHERE name='apple'), 20, 'db')