package org.s3.individualassignment.backend.controller.DTO;

import org.s3.individualassignment.backend.business.impl.Recipes.RecipeConverter;
import org.s3.individualassignment.backend.domain.Ingredient;
import org.s3.individualassignment.backend.domain.Recipe;

import java.util.stream.Collectors;

public class IngredientDTOConverter {
    private IngredientDTOConverter(){

    }
    public static IngredientDTO convert(Ingredient ingredient){
        return IngredientDTO.builder()
                .id(ingredient.getId())
                .name_of_ingredient(ingredient.getName_of_ingredient())
                .link(ingredient.getLink())
                .price(ingredient.getPrice())
                .amount_unit(ingredient.getAmount_unit())
                .recipes(ingredient.getRecipes().stream().map(RecipeConverter::convert).toList())
                .build();
    }
}
