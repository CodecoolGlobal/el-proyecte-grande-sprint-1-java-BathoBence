CREATE TABLE IF NOT EXISTS recipe (
    id          SMALLSERIAL PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    description TEXT         NOT NULL
);

CREATE TABLE IF NOT EXISTS food_category (
    id SMALLSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NUll
);

CREATE TABLE IF NOT EXISTS ingredient(
    id            SMALLSERIAL PRIMARY KEY AUTOINCREMENT,
    name          VARCHAR(255) NOT NULL,
    food_category INTEGER REFERENCES food_category(id) NOT NULL
);

CREATE TABLE IF NOT EXISTS recipe_ingredient(
    id SMALLSERIAL PRIMARY KEY,
    recipe_id INTEGER REFERENCES recipe(id) NOT NULL,
    ingredient_id INTEGER REFERENCES ingredient(id) NOT NULL,
    amount INTEGER NOT NULL,
    unit VARCHAR(80) NOT NULL
);

CREATE TABLE IF NOT EXISTS user_account(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS pantry(
    id SERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES user_account(id) NOT NULL,
    ingredient_id INTEGER REFERENCES ingredient(id) NOT NULL
);