package eu.piiroinen.recipes.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="ainekset")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_ainekset")
    private Long ingredientId;
    @NotNull
    @Column(name="järjestysluku", nullable = false)
    int ordinal;
    @Column(name="määrä", length = 50)
    String amount;
    @NotNull
    @Column(name="aines", length = 50, nullable = false)
    String ingredientName;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_resepti")
    private Recipe recipe;

    public Ingredient() {}

    public Ingredient(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public Ingredient(String amount, String ingredientName) {
        this.amount = amount;
        this.ingredientName = ingredientName;
    }

    public Ingredient(int ordinal, String amount, String ingredientName) {
        this.ordinal = ordinal;
        this.amount = amount;
        this.ingredientName = ingredientName;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(int ordinal) {
        this.ordinal = ordinal;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
}