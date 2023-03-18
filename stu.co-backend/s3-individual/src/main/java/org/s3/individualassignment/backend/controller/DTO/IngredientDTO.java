package org.s3.individualassignment.backend.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.s3.individualassignment.backend.domain.Recipe;


import java.util.List;

@Getter
@Builder
@Setter
@AllArgsConstructor
public class IngredientDTO {
        private Long id;
        private String name_of_ingredient;
        private String link;
        private Double price;
        private String amount_unit;
        private List<Recipe> recipes;
}
