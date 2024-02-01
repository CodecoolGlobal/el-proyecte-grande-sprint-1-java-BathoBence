INSERT INTO pantry (id, user_id, ingedient_id)
VALUES (DEFAULT, (SELECT id FROM user_account WHERE name='Bence'))