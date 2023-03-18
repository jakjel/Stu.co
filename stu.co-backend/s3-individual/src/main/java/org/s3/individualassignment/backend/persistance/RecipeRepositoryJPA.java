package org.s3.individualassignment.backend.persistance;

import org.s3.individualassignment.backend.persistance.Entity.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeRepositoryJPA extends JpaRepository<RecipeEntity, Long> {


    @Query(value = "SELECT DISTINCT r FROM RecipeEntity as r JOIN fetch r.ingredients as i WHERE i.nameOfIngredient LIKE %:ingredient%")
    List<RecipeEntity> getRecipesByIngredient(@Param("ingredient") String ingredient);


}
