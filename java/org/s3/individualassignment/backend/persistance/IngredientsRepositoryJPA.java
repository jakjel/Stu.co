package org.s3.individualassignment.backend.persistance;

import org.s3.individualassignment.backend.persistance.Entity.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IngredientsRepositoryJPA extends JpaRepository<IngredientEntity, Long> {

    @Query(value = "SELECT r.ingredients FROM RecipeEntity as r WHERE r.id = :recipeId")
    List<IngredientEntity> getRecipesIngredientsByRecipeId(@Param("recipeId") Long recipeId);


}
