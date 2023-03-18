package org.s3.individualassignment.backend.controller;

import lombok.AllArgsConstructor;
import org.s3.individualassignment.backend.business.impl.exceptions.UnauthorizedDataAccessException;
import org.s3.individualassignment.backend.controller.DTO.*;
import org.s3.individualassignment.backend.configuration.security.isAuthenticated.IsAuthenticated1;
import org.s3.individualassignment.backend.domain.AccessToken;
import org.s3.individualassignment.backend.domain.UserRole;
import org.s3.individualassignment.backend.interfaces.RecipesManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/recipes")
@CrossOrigin(origins = "http://localhost:3000")
public class RecipesController {
    private final RecipesManager recipesManager;
    private AccessToken requestAccessToken;

    @IsAuthenticated1
    @RolesAllowed({"ROLE_USER", "ROLE_ADMIN"})
    //retrieve recipe by giving its id to prametres
    @GetMapping("{id}")
    public ResponseEntity<RecipeDTO> getRecipe(@PathVariable(value = "id") final long id) {
        final Optional<RecipeDTO> recipeOptional = recipesManager.getRecipe(id).map(RecipeDTOConverter::convert);
        if (recipeOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(recipeOptional.get());
    }
    //retrieve all recipes
    @IsAuthenticated1
    @RolesAllowed({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping("/all") // without all
    public ResponseEntity<GetAllRecipesResponse> getAllRecipes() {
        if (!requestAccessToken.hasRole(UserRole.USER.name()) && !requestAccessToken.hasRole(UserRole.ADMIN.name())) {
                throw new UnauthorizedDataAccessException("USER_IS_NOT_AUTHORIZED_TO_SEE_THIS");
        }
        List<RecipeDTO> allRecipes = recipesManager.getAllRecipes().stream()
                .map(RecipeDTOConverter::convert)
                .toList();
        GetAllRecipesResponse response = new GetAllRecipesResponse();
        if (allRecipes.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            response.setRecipes(allRecipes);
        }
        return ResponseEntity.ok(response);
    }
    @IsAuthenticated1
    @RolesAllowed({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping("/all/{ingredient}") //change to just ingredient
    public ResponseEntity<GetAllRecipesResponse> getAllRecipesWithIngredient(@PathVariable(value = "ingredient") final String ingredient) {
        if (!requestAccessToken.hasRole(UserRole.USER.name())) {
                throw new UnauthorizedDataAccessException("USER_HAS_NO_ACCESS");
        }
        List<RecipeDTO> allRecipes = recipesManager.searchRecipesByIngredient(ingredient).stream()
                .map(RecipeDTOConverter::convert)
                .toList();
        GetAllRecipesResponse response = new GetAllRecipesResponse();
        if (allRecipes.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            response.setRecipes(allRecipes);
        }
        return ResponseEntity.ok(response);
    }

    @IsAuthenticated1
    @RolesAllowed({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping("/ingredients/{recipeId}") //change to just ingredient
    public ResponseEntity<GetAllIngredientsResponse> getAllRecipesWithIngredient(@PathVariable(value = "recipeId") final Long recipeId) {
        List<IngredientDTO> allRecipesIngredients = recipesManager.getRecipesIngredients(recipeId).stream()
                .map(IngredientDTOConverter::convert)
                .toList();
        GetAllIngredientsResponse response = new GetAllIngredientsResponse();
        if (allRecipesIngredients.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            response.setIngredients(allRecipesIngredients);
        }
        return ResponseEntity.ok(response);
    }
}
