package org.spring.recipemanagement;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("recipeitems") //  to specify the collection name that will be used by the model.
public class Recipe {  // This is our model
    @Id  // to specify the primary key for DB
    private String id;
    private String title;
    private int cookTime;
    private Boolean vegan;
//    private String ingredients; // show be a hashmap

//    private int score;
//    private String notes;
//    private String instructions;
//    private int prepTime;
//    private String category;
    private String cuisine;

    public Recipe() {
    }

    public Recipe(String title, int cookTime, Boolean vegan, String cuisine) {
        this.title = title;
        this.cuisine = cuisine;
        this.cookTime = cookTime;
        this.vegan = vegan;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    @Override
    public String toString() {
        return "Recipe{" +
                ", title='" + title + '\'' +
                ", cookTime=" + cookTime +
                ", vegan=" + vegan +
//                ", ingredients='" + ingredients + '\'' +
                ", cuisine='" + cuisine + '\'' +
                '}';
    }
}
