package eu.piiroinen.recipes.controller;

import eu.piiroinen.recipes.model.Recipe;
import eu.piiroinen.recipes.repository.RecipeRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/recipe")
@Controller
public class RecipeController {

    private static final Logger LOG = LoggerFactory.getLogger(RecipeController.class);

    @Autowired
    private RecipeRepository recipeRepository;

    // GET endpoints

    @GetMapping("/id/{id}")
    public ResponseEntity<Map<String, Recipe>> getRecipeById(
            @PathVariable(name="id") Long recipeId) {
        try {
            Map<String, Recipe> response = new HashMap<>();
            Optional<Recipe> recipe = this.recipeRepository.findById(recipeId);
            if (recipe.isPresent()) {
                response.put("recipe", recipe.get());
            }
            // If an empty response body is received with status code 200, no recipe by given id was found
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(response);

        } catch (Exception e) {
            LOG.error("An exception occurred in RecipeController with route /recipe/id, parameter: {}", recipeId);
            LOG.error("\nAnd with exception message: ", e);
            Map<String, Recipe> emptyResponse = new HashMap<>();
            // Empty response with status code 500 is indicative of a server error, perhaps retry?
            return ResponseEntity.status(500)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(emptyResponse);
        }
    }


    @GetMapping("/categories")
    public ResponseEntity<Map<String, Set<Recipe>>> getRecipesForCategory(
            @RequestParam(name="recipeCategoryId") Long recipeCategoryId) {
        try {
            Map<String, Set<Recipe>> response = new HashMap<>();
            Set<Recipe> recipes = this.recipeRepository.findByCategoriesForRecipeOrderByRecipeName(recipeCategoryId);
            if (Optional.ofNullable(recipes).isPresent()) {
                response.put("recipesByCategory", recipes);
            }
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(response);
        } catch (Exception e) {
            LOG.error("An exception occurred in RecipeController: ", e);
            Map<String, Set<Recipe>> emptyResponse = new HashMap<>();
            return ResponseEntity.status(500)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(emptyResponse);
        }
    }

    @GetMapping("/season/{season}")
    public ResponseEntity<Map<String, List<Recipe>>> getRecipesBySeason(
            @PathVariable String season) {
        try {
            Map<String, List<Recipe>> response = new HashMap<>();
            List<Recipe> recipesBySeason = this.recipeRepository.findRecipesBySeasonOrderByRecipeName(season);
            response.put("recipes", recipesBySeason);
            // A successful fetch may not always return something, because season is not obligatory for recipes.
            // Status code 200 with empty response tells us there are no recipes in the selected season available.
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(response);
        } catch (Exception e) {
            LOG.error("An exception occurred in RecipeController with route /recipe/season, path variable: {}", season);
            LOG.error("\nAnd with exception message: ", e);
            Map<String, List<Recipe>> emptyResponse = new HashMap<>();
            // Status code 500 is indicative of a server error
            return ResponseEntity.status(500)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(emptyResponse);
        }
    }

    // Please note that this mapping will change after user class is added
    @GetMapping("/favourite")
    public ResponseEntity<Map<String, Optional<List<Recipe>>>> getFavouriteRecipes() {
        try {
            Map<String, Optional<List<Recipe>>> response = new HashMap<>();
            Optional<List<Recipe>> favourites = this.recipeRepository.findRecipesByIsFavouriteIsTrueOrderByRecipeName();
            if (favourites.isPresent()) {
                response.put("recipes", favourites);
            }
            // If an empty response body is received with status code 200, no favourite recipes exist
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(response);
        } catch (Exception e) {
            LOG.error("An exception occurred in RecipeController with route /recipe/favourite: ", e);
            Map<String, Optional<List<Recipe>>> emptyResponse = new HashMap<>();
            // Empty response body with status code 500 is indicative of a server error
            return ResponseEntity.status(500)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(emptyResponse);
        }
    }

    // POST endpoints
    @PostMapping("/new")
    Recipe newRecipe(@Valid @RequestBody Recipe newRecipe) {
        return this.recipeRepository.save(newRecipe);
    }

}
