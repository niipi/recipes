package eu.piiroinen.recipes.controller;

import eu.piiroinen.recipes.model.Recipe;
import eu.piiroinen.recipes.testdata.FrontendTestRecipeGenerator;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FrontendTestController {

    private FrontendTestRecipeGenerator testRecipeGenerator = new FrontendTestRecipeGenerator();

    @RequestMapping(value="/frontendtest")
    public ResponseEntity<Map<String, List<Recipe>>> getTestRecipeListing() {
        try {
            Map<String, List<Recipe>> response = new HashMap<>();

            List<Recipe> recipes = testRecipeGenerator.generateTestRecipeListing();
            response.put("recipes", recipes);

            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(response);
        } catch (Exception e) {
            Map<String, List<Recipe>> emptyResponse = new HashMap<>();
            return ResponseEntity.badRequest()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(emptyResponse);
        }
    }
        
}