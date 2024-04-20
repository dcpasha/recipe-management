package org.spring.recipemanagement;

import java.util.concurrent.atomic.AtomicInteger;

public class Recipe {

    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id;
    private String name;
    private int cookTime;
    private Boolean vegan;
    private String ingredients;
    public int getId() {
        return id;
    }

//    private int score;
//    private String notes;
//    private String instructions;
//    private int prepTime;
//    private String category;


    public Recipe() {
        this.id = count.incrementAndGet();
    }

    private String cuisine;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public int getCookTime() {
        return cookTime;
    }

    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }


    public Boolean getVegan() {
        return vegan;
    }

    public void setVegan(Boolean vegan) {
        this.vegan = vegan;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }


}
