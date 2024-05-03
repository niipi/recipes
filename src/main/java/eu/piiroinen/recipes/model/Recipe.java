package eu.piiroinen.recipes.model;

import jakarta.persistence.*;


import java.util.List;
import java.util.Set;

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
        @Column(name="kuva", length = 250)
        String recipeImageUrl;
        @OneToMany(mappedBy = "id_resepti")
        List<Ingredient> ingredients;
        @OneToMany(mappedBy ="id_resepti")
        List<Instruction> instructions;
        @ManyToMany
        @JoinTable(name = "reseptin_kategoria", joinColumns = @JoinColumn(name = "kategoria_id"), inverseJoinColumns = @JoinColumn(name = "id"))
        Set<RecipeCategory> categoriesForRecipe;

    public Recipe (String name, boolean isFavourite, String season, List<Ingredient> ingredients, List<Instruction> instructions, Set<RecipeCategory> categories, String recipeImageUrl) {
        this.name = name;
        this.isFavourite = isFavourite;
        this.season = season;
        this.recipeImageUrl = recipeImageUrl;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.categoriesForRecipe = categories;

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

    public String getRecipeImageUrl() {
        return recipeImageUrl;
    }
        /*
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public Set<RecipeCategory> getCategories() {
        return categories;
    }

    }*/
}