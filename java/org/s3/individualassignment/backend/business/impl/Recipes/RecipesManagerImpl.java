package org.s3.individualassignment.backend.business.impl.Recipes;

import lombok.AllArgsConstructor;
import org.s3.individualassignment.backend.domain.Ingredient;
import org.s3.individualassignment.backend.interfaces.RecipesManager;
import org.s3.individualassignment.backend.domain.Recipe;
import org.s3.individualassignment.backend.interfaces.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class RecipesManagerImpl implements RecipesManager {
    private final RecipeRepository recipeRepository;
    //builds one recipe, tady musim jeste vytvorit dto class
    @Override
    public Optional<Recipe> getRecipe(long recipeId) {
        return recipeRepository.findById(recipeId);
    }
    //searches for recipes that contain ingredient in parameter
    public List<Recipe> searchRecipesByIngredient(String ingredient){
        return recipeRepository.getAllRecipesWithIngredient(ingredient);
    }

    @Override
    public List<Ingredient> getRecipesIngredients(Long id) {
        return recipeRepository.getRecipesIngredients(id);
    }

    //builds list of recipes, tady musim jeste vytvorit dto class
    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.getAllRecipes();
    }
}
