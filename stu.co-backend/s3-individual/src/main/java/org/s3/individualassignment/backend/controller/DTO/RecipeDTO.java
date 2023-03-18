package org.s3.individualassignment.backend.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.s3.individualassignment.backend.domain.Ingredient;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class RecipeDTO {
    private Long id;
    private String title;
    private String video_link;
    private String description;
    private Integer amount_of_people;
    private List<Ingredient> ingredients;
}
