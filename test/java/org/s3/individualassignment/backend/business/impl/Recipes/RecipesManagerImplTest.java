package org.s3.individualassignment.backend.business.impl.Recipes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.s3.individualassignment.backend.domain.Recipe;
import org.s3.individualassignment.backend.interfaces.RecipeRepository;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RecipesManagerImplTest {

    @Mock
    private RecipeRepository recipeRepositoryMock;

    @InjectMocks
    private RecipesManagerImpl recipesManager;

    @Test
    void getRecipe_happyflow() {
        Optional<Recipe> recipe = Optional.ofNullable(Recipe.builder().id(1L).title("Test").video_link("https://www.thisIsATestVideoLink.com").description("test description").amount_of_people(2).build());
        when(recipeRepositoryMock.findById(1L))
                .thenReturn(recipe);
        Optional<Recipe> actualResult = recipesManager.getRecipe(1L);

        Optional<Recipe> expectedResult = Optional.ofNullable(Recipe.builder().id(1L).title("Test").video_link("https://www.thisIsATestVideoLink.com").description("test description").amount_of_people(2).build());

        assertEquals(expectedResult, actualResult);
        verify(recipeRepositoryMock).findById(1L);
    }
    @Test
    void getRecipe_unhappyflow() {
        when(recipeRepositoryMock.findById(3L))
                .thenReturn( Optional.empty());
        Optional<Recipe> actualResult = recipesManager.getRecipe(3L);

        Optional<Recipe> expectedResult = Optional.empty();

        assertEquals(expectedResult, actualResult);
        verify(recipeRepositoryMock).findById(3L); //is this the right way of doing it?
    }

    @Test
    void searchRecipesByIngredient() {
        List<Recipe> listOfRecipes = List.of(Recipe.builder().id(1L).title("Test").video_link("https://www.thisIsATestVideoLink.com").description("test description").amount_of_people(2).build(),Recipe.builder().id(2L).title("Test2").video_link("https://www.thisIsATestVideoLink2.com").description("test description2").amount_of_people(4).build());
        when(recipeRepositoryMock.getAllRecipesWithIngredient("paprika"))
                .thenReturn(listOfRecipes);

        List<Recipe> actualResult = recipesManager.searchRecipesByIngredient("paprika");
        List<Recipe> expectedResult = List.of(Recipe.builder().id(1L).title("Test").video_link("https://www.thisIsATestVideoLink.com").description("test description").amount_of_people(2).build(),Recipe.builder().id(2L).title("Test2").video_link("https://www.thisIsATestVideoLink2.com").description("test description2").amount_of_people(4).build());

        assertEquals(expectedResult, actualResult);
        verify(recipeRepositoryMock).getAllRecipesWithIngredient("paprika");
    }


    @Test
    void getAllRecipes() {
        List<Recipe> listOfRecipes = List.of(Recipe.builder().id(1L).title("Test").video_link("https://www.thisIsATestVideoLink.com").description("test description").amount_of_people(2).build(),Recipe.builder().id(2L).title("Test2").video_link("https://www.thisIsATestVideoLink2.com").description("test description2").amount_of_people(4).build());
        when(recipeRepositoryMock.getAllRecipes())
                .thenReturn(listOfRecipes);

        List<Recipe> actualResult = recipesManager.getAllRecipes();
        List<Recipe> expectedResult = List.of(Recipe.builder().id(1L).title("Test").video_link("https://www.thisIsATestVideoLink.com").description("test description").amount_of_people(2).build(),Recipe.builder().id(2L).title("Test2").video_link("https://www.thisIsATestVideoLink2.com").description("test description2").amount_of_people(4).build());

        assertEquals(expectedResult, actualResult);
        verify(recipeRepositoryMock).getAllRecipes();
    }
}