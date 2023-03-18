package org.s3.individualassignment.backend.persistance;

import lombok.AllArgsConstructor;
import org.s3.individualassignment.backend.business.impl.Ingredients.IngredientConverter;
import org.s3.individualassignment.backend.business.impl.Recipes.RecipeConverter;
import org.s3.individualassignment.backend.domain.Ingredient;
import org.s3.individualassignment.backend.domain.Recipe;
import org.s3.individualassignment.backend.interfaces.RecipeRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
@AllArgsConstructor
public class RecipeRepositoryImpl implements RecipeRepository {
    private final RecipeRepositoryJPA recipeRepositoryJPA;
    private final IngredientsRepositoryJPA ingredientsRepositoryJPA;

    @Override
    public Optional<Recipe> findById(long id) {
        return recipeRepositoryJPA.findById(id).map(RecipeConverter::convert);
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepositoryJPA.findAll().stream().map(RecipeConverter::convert).toList();
    }

    @Override
    public List<Recipe> getAllRecipesWithIngredient(String ingredient) {
        return recipeRepositoryJPA.getRecipesByIngredient(ingredient).stream().map(RecipeConverter::convert)
                .toList();
    }


    @Override
    //this method retrieves list of ingredients to one specific recipe
    public List<Ingredient> getRecipesIngredients(Long id){
        return ingredientsRepositoryJPA.getRecipesIngredientsByRecipeId(id).stream().map(IngredientConverter::convert).toList();
    }


}
