package org.s3.individualassignment.backend.business.impl.Recipes;


import org.s3.individualassignment.backend.domain.Recipe;
import org.s3.individualassignment.backend.persistance.Entity.RecipeEntity;



public class RecipeConverter {
    private RecipeConverter(){

    }
    public static Recipe convert(RecipeEntity recipe) {
        return Recipe.builder()
                .id(recipe.getId())
                .title(recipe.getTitle())
                .description(recipe.getDescription())
                .video_link(recipe.getVideo())
                .ingredients(recipe.getIngredients())
                .amount_of_people(recipe.getAmountOfPeople())
                .build();
    }
}
