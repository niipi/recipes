package eu.piiroinen.recipes.controller;

import eu.piiroinen.recipes.model.Recipe;
import eu.piiroinen.recipes.model.RecipeCategory;
import eu.piiroinen.recipes.repository.RecipeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RequestMapping("/recipe")
@Controller
public class RecipeController {

    private static final Logger LOG = LoggerFactory.getLogger(RecipeController.class);

    @Autowired
    private RecipeRepository recipeRepository;

    @GetMapping("/id")
    public ResponseEntity<Map<String, Recipe>> getRecipeById(
            @RequestParam(name="recipeId") Long recipeId) {
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
    public ResponseEntity<Map<String, List<RecipeCategory>>> getRecipeCategoriesByRecipeId(
            @RequestParam(name="recipeId") Long recipeId) {
        try {
            Map<String, List<RecipeCategory>> response = new HashMap<>();
            Optional<List<RecipeCategory>> recipeCategoryList = this.recipeRepository.findCategoriesByRecipeId(recipeId);
            if (recipeCategoryList.isPresent()) {
                response.put("recipeCategories", recipeCategoryList.get());
            }
            // If an empty response body is received with status code 200, either no recipe with given id exists
            // or the corresponding recipe has no relation to known categories
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(response);

        } catch (Exception e) {
            LOG.error("An exception occurred in RecipeController with route /recipe/id, parameter: {}", recipeId);
            LOG.error("\nAnd with exception message: ", e);
            Map<String, List<RecipeCategory>> emptyResponse = new HashMap<>();
            // Empty response with status code 500 is indicative of a server error, perhaps retry?
            return ResponseEntity.status(500)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(emptyResponse);
        }
    }

    @GetMapping("/{season}")
    public ResponseEntity<Map<String, List<Recipe>>> getRecipesBySeason(
            @PathVariable String season) {
        try {
            Map<String, List<Recipe>> response = new HashMap<>();
            List<Recipe> recipesBySeason = this.recipeRepository.findRecipesBySeason(season);
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

    @GetMapping("/favourite")
    public ResponseEntity<Map<String, Optional<List<Recipe>>>> getFavouriteRecipes() {
        try {
            Map<String, Optional<List<Recipe>>> response = new HashMap<>();
            Optional<List<Recipe>> favourites = this.recipeRepository.findRecipesByFavouriteIsTrue();
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

}
