package org.s3.individualassignment.backend.controller.DTO;

import org.s3.individualassignment.backend.business.impl.Ingredients.IngredientConverter;
import org.s3.individualassignment.backend.domain.Recipe;


public class RecipeDTOConverter {
    private RecipeDTOConverter(){

    }
    public static RecipeDTO convert(Recipe recipe){
        return RecipeDTO.builder()
                .id(recipe.getId())
                .title(recipe.getTitle())
                .description(recipe.getDescription())
                .video_link(recipe.getVideo_link())
                .amount_of_people(recipe.getAmount_of_people())
                .ingredients(recipe.getIngredients().stream().map(IngredientConverter::convert).toList())
                .build();
    }
}
