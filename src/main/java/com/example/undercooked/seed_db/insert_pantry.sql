INSERT INTO pantry (id, user_id, ingredient_id)
VALUES (DEFAULT, (SELECT id FROM user_account WHERE name='Bence'), (SELECT id FROM ingredient WHERE name = 'apple'))