package org.s3.individualassignment.backend.business.impl.Ingredients;


import org.s3.individualassignment.backend.domain.Ingredient;
import org.s3.individualassignment.backend.persistance.Entity.IngredientEntity;



public class IngredientConverter {
    private IngredientConverter(){

    }
    public static Ingredient convert(IngredientEntity ingredient) {
        return Ingredient.builder()
                .id(ingredient.getId())
                .name_of_ingredient(ingredient.getNameOfIngredient())
                .link(ingredient.getLink())
                .price(ingredient.getPrice())
                .recipes(ingredient.getRecipes())
                .amount_unit(ingredient.getAmount_unit())
                .build();
    }
}
