package eu.piiroinen.recipes.model;

import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name="resepti")
public class Recipe {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        private Long recipeId;
        @Column(name="nimi", length = 250, nullable = false)
        String name;
        @Column(name="suosikki", nullable = false)
        boolean isFavourite;
        @Column(name="sesonki", length = 10)
        String season;
        //TODO: relational columns

        @OneToMany(mappedBy = "ainekset")
        List<Ingredient> ingredients;
        @OneToMany(mappedBy ="ohje")
        List<Instruction> instructions;
         /*
        List<RecipeCategory> categories;
        String recipeImageUrl;
*/

    public Recipe(String name, boolean isFavourite, String season, List<Ingredient> ingredients, List<Instruction> instructions) {
        this.name = name;
        this.isFavourite = isFavourite;
        this.season = season;
        this.ingredients = ingredients;
        this.instructions = instructions;
        /*
        this.categories = categories;
        this.recipeImageUrl = recipeImageUrl;
        */
    }

    public Recipe() {}


    public Long getId() {
        return recipeId;
    }

    public String getName() {
        return name;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }
/*
    public List<RecipeCategory> getCategories() {
        return categories;
    }

    public String getRecipeImageUrl() {
        return recipeImageUrl;
    }*/
}