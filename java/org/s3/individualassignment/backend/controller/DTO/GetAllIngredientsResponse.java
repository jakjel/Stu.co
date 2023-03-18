package org.s3.individualassignment.backend.controller.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class GetAllIngredientsResponse {
    @Setter//setting recipes in the controller
    @Getter//checking if recipes is empty, therefore getter
    private List<IngredientDTO> ingredients;
}
