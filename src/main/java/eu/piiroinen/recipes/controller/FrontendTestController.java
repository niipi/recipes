package eu.piiroinen.recipes.controller;

import eu.piiroinen.recipes.model.Recipe;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

@Controller
public class FrontendTestController {

    @RequestMapping(value="/frontendtest")
    public ResponseEntity<ArrayList<Recipe>> getTestRecipeListing() {
        return null;
    }
        
}