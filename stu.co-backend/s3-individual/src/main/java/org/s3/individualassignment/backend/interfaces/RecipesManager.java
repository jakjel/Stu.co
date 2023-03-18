package org.s3.individualassignment.backend.interfaces;

import org.s3.individualassignment.backend.domain.Ingredient;
import org.s3.individualassignment.backend.domain.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipesManager {
    //retrieves recipe by id
    Optional<Recipe> getRecipe(long recipeId);
    //retrieves all recipes
    List<Recipe> getAllRecipes();
    //retrieve all recipes with searched ingredient
    List<Recipe> searchRecipesByIngredient(String ingredient);
    //get a recipe with ingredients
    List<Ingredient> getRecipesIngredients(Long id);



}
