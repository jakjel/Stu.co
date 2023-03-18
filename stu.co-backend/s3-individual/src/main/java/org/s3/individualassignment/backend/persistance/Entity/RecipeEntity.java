package org.s3.individualassignment.backend.persistance.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "recipes2")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RecipeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private Long id;
    @NotBlank
    @Column(name = "title")
    private String title;
    @NotBlank
    @Column(name = "video")
    private String video;
    @NotBlank
    @Column(name = "description") //because i have one recipe to many ingredients
    private String description;
    @NotBlank
    @Column(name = "amount_of_people")
    private Integer amountOfPeople;
    @ManyToMany(
            fetch=FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "recipes_ingredients2",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    @JsonIgnore
    private List<IngredientEntity> ingredients;
}
