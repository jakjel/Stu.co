package org.s3.individualassignment.backend.interfaces;

import org.s3.individualassignment.backend.domain.Ingredient;
import org.s3.individualassignment.backend.domain.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository {
    public Optional<Recipe> findById(long id);
    public List<Recipe> getAllRecipes();
    public List<Recipe> getAllRecipesWithIngredient(String ingredient);
    public List<Ingredient> getRecipesIngredients(Long id);
}
