package eu.piiroinen.recipes.controller;

import eu.piiroinen.recipes.model.RecipeCategory;
import eu.piiroinen.recipes.repository.RecipeCategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;


@RequestMapping("/categories")
@Controller
public class RecipeCategoryController {

    private static final Logger LOG = LoggerFactory.getLogger(RecipeCategoryController.class);

    @Autowired
    private RecipeCategoryRepository recipeCategoryRepository;

    @GetMapping("/all")
    public ResponseEntity<Map<String, Set<RecipeCategory>>> getAllCategories() {
        try {
            Set<RecipeCategory> categories = this.recipeCategoryRepository.findAll();
            Map<String, Set<RecipeCategory>> response = new HashMap<>();
            response.put("categories", categories);
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(response);
        } catch (Exception e) {
            LOG.error("An exception occurred in RecipeCategoryController: ", e);
            Map<String, Set<RecipeCategory>> emptyResponse = new HashMap<>();
            emptyResponse.put("categories", new HashSet<>());
            return ResponseEntity.status(500)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(emptyResponse);
        }
    }

    @GetMapping("/recipe")
    public ResponseEntity<Map<String, Set<RecipeCategory>>> getRecipeCategoriesByRecipeId(
            @RequestParam(name="recipeId") Long recipeId) {
        try {
            Map<String, Set<RecipeCategory>> response = new HashMap<>();
            Optional<Set<RecipeCategory>> recipeCategoryList = this.recipeCategoryRepository.findCategoriesByCategoriesForRecipe(recipeId);
            if (recipeCategoryList.isPresent()) {
                response.put("recipeCategories", recipeCategoryList.get());
            }
            // If an empty response body is received with status code 200, either no recipe with given id exists
            // or the corresponding recipe has no relation to known categories
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(response);

        } catch (Exception e) {
            LOG.error("An exception occurred in RecipeCategoryController with route /recipe/recipeId, parameter: {}", recipeId);
            LOG.error("\nAnd with exception message: ", e);
            Map<String, Set<RecipeCategory>> emptyResponse = new HashMap<>();
            // Empty response with status code 500 is indicative of a server error, perhaps retry?
            return ResponseEntity.status(500)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(emptyResponse);
        }
    }
}
