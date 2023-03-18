package org.s3.individualassignment.backend.persistance.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "ingredients2")
@Builder
@Getter
@Setter
@AllArgsConstructor //helps with error could not be accesed from outside the package, it says it is private otherwise
@NoArgsConstructor
public class IngredientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id")
    private Long id;
    @NotBlank
    @Column(name = "name_of_ingredient")
    private String nameOfIngredient;
    @NotBlank
    @Column(name = "link")
    private String link;
    @NotBlank
    @Column(name = "price")
    private Double price;
    @NotBlank
    @Column(name = "amount_unit")
    private String amount_unit;
    @ManyToMany(
            fetch=FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "ingredients")
    @JsonIgnore
    private List<RecipeEntity> recipes;
}
