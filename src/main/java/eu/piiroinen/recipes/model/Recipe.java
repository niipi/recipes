package eu.piiroinen.recipes.model;

import jakarta.persistence.*;


import java.util.List;
import java.util.Set;

@Entity
@Table(name="resepti")
public class Recipe {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id_resepti")
        private Long recipeId;
        @Column(name="nimi", length = 250, nullable = false)
        String name;
        @Column(name="suosikki", nullable = false)
        boolean isFavourite;
        @Column(name="sesonki", length = 10)
        String season;
        @Column(name="kuva", length = 250)
        String recipeImageUrl;
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe", cascade = CascadeType.ALL)
        public List<Ingredient> ingredients;
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe", cascade = CascadeType.ALL)
        public List<Instruction> instructions;
        @ManyToMany
        @JoinTable(name = "reseptin_kategoria",
                joinColumns = @JoinColumn(name = "id_resepti", referencedColumnName = "id_resepti"),
                inverseJoinColumns = @JoinColumn(name = "id_kategoria", referencedColumnName = "id_kategoria"))
        public List<RecipeCategory> categoriesForRecipe;

    public Recipe (String name, boolean isFavourite, String season, List<Ingredient> ingredients, List<Instruction> instructions, List<RecipeCategory> categories, String recipeImageUrl) {
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