INSERT INTO ingredient (id, name, food_category)
VALUES (DEFAULT, 'apple', (SELECT id FROM food_category WHERE name='fruits'))