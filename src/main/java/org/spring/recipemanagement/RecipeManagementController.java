package org.spring.recipemanagement;

import com.google.gson.Gson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class RecipeManagementController {

    List<Recipe> recipeList = new ArrayList<>();
    Map<Integer, Recipe> recipeMap = new HashMap<>();
    Gson gson = new Gson();  // to serialize and deserialize

    @GetMapping("/home")
    public String getHome(){
        return gson.toJson("Hakuna Matata");
    }

    @PostMapping("/add") // to add a new recipe to list
    public String addRecipe(@RequestBody Recipe recipe){
//        recipeList.add(recipe);
        recipeMap.put(recipe.getId(), recipe);
        return String.format(recipe.getName() + " was added");
    }

    @GetMapping("/recipes") // return all recipes
    public String returnAllRecipes(){
//        return gson.toJson(recipeList);
        return gson.toJson(recipeMap);
    }

    @GetMapping("/recipe")  // return a recipe by an id
    public ResponseEntity<String> returnRecipeById(@RequestParam(required = false) int id) { // @RequestParam to accept query parameters
        Recipe recipe;
        if (!recipeMap.containsKey(id)) {
            // todo: throw an error that it does not exist
        }
            recipe = recipeMap.get(id);
            return ResponseEntity.ok(gson.toJson("The recipe name is " + recipe.getName()));
    }

    @DeleteMapping("/remove")  // delete by id
    public String deleteRecipeById(@RequestParam(required = false) int id){
        if (!recipeMap.containsKey(id)) {
            // todo: throw an error that it does not exist
        }
        String recipeName = recipeMap.get(id).getName();
        recipeMap.remove(id);
        return "Removed " + recipeName + " from recipes";
    }

    @DeleteMapping("/removeAll")  // remove everything
    public void deleteAllRecipes(){
//        recipeList = new ArrayList<>();
        recipeMap.clear();
    }

    // todo: edit a recipe by id
    // todo: exception handling
    // todo: databased persistence

} // end RecipeManagementController
