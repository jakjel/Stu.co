CREATE TABLE recipes_ingredients2
(
    recipe_id       int,
    ingredient_id       int,
    CONSTRAINT pk_recipes_ingredients PRIMARY KEY (recipe_id, ingredient_id)
);

ALTER TABLE recipes_ingredients2
    ADD CONSTRAINT fk_recingr_on_recipe FOREIGN KEY (recipe_id) REFERENCES recipes2 (recipe_id);

ALTER TABLE recipes_ingredients2
    ADD CONSTRAINT fk_recingr_on_ingredient FOREIGN KEY (ingredient_id) REFERENCES ingredients2 (ingredient_id);