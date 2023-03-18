package org.s3.individualassignment.backend.controller.DTO;

import lombok.*;

import java.util.List;

@NoArgsConstructor
public class GetAllRecipesResponse {
    @Setter//setting recipes in the controller
    @Getter//checking if recipes is empty, therefore getter
    private List<RecipeDTO> recipes;
}