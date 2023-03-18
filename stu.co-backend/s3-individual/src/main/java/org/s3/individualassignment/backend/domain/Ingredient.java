package org.s3.individualassignment.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.s3.individualassignment.backend.persistance.Entity.RecipeEntity;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class Ingredient {
    private Long id;
    private String name_of_ingredient;
    private String link;
    private Double price;
    private String amount_unit;
    private List<RecipeEntity> recipes;
}
