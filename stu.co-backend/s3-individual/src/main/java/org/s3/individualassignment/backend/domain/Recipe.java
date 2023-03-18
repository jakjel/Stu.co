package org.s3.individualassignment.backend.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.s3.individualassignment.backend.persistance.Entity.IngredientEntity;

import java.util.List;


@Builder
@Getter
@EqualsAndHashCode
public class Recipe {
    private Long id;
    private String title;
    private String video_link;
    private String description;
    private List<IngredientEntity> ingredients;
    private Integer amount_of_people;
}
