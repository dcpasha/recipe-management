package org.spring.recipemanagement;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@RestController
public class RecipeManagementController {

    @Autowired
    RecipeItemRepository recipeItemRepo;

    List<Recipe> recipeList = new ArrayList<>();
    Map<Integer, Recipe> recipeMap = new HashMap<>();
    Gson gson = new Gson();  // to serialize and deserialize

    @GetMapping("/home")
    public String getHome(){
        return gson.toJson("Hakuna Matata");
    }

    @PostMapping("/add") // adds a new recipe to list
    public String addRecipe(@RequestBody Recipe recipe){
        recipeItemRepo.save(recipe); // save recipe to db
        return String.format(recipe.getTitle() + " was added");
    }

    @GetMapping("/recipes") // returns all recipes
    public String returnAllRecipes(){
        List<Recipe> recipes = recipeItemRepo.findAll();
        return gson.toJson(recipes);
    }

    @GetMapping("/recipes/cuisine")  // return all recipes from a certain cuisine
    public ResponseEntity<String> returnRecipeByCuisine(@RequestParam(required = false) String type) { // @RequestParam to accept query parameters//
//         if (!recipeMap.containsKey(id)) {
//            throw new RecipeNotFoundException("Unable to return recipe because id # " + cuisine + " does not exist");
//         }
        List<Recipe> recipes = recipeItemRepo.findRecipesByCuisine(type);  // list with all recipes of a certain type
        return ResponseEntity.ok(gson.toJson(recipes));
    }

    @GetMapping("/recipes/title")  // return a recipes by its name
    // Assume that each recipe title is unique
    public ResponseEntity<String> returnRecipeByTitle(@RequestParam(required = false) String name) { // @RequestParam to accept query parameters//
//         if (!recipeMap.containsKey(id)) {
//            throw new RecipeNotFoundException("Unable to return recipe because id # " + cuisine + " does not exist");
//         }
        List<Recipe> recipe = recipeItemRepo.findRecipesByTitle(name);  // list with all recipes of a certain type
        return ResponseEntity.ok(gson.toJson(recipe));
    }

    @DeleteMapping("/remove")  // delete a recipe by id
    public String deleteRecipeById(@RequestParam(required = false) String id){
//        if (!recipeMap.containsKey(id)) {
//            throw new RecipeNotFoundException("Unable to delete recipe because id # " + id + " does not exist");
//        }
        recipeItemRepo.deleteById(id);
        return "Removed " + id + " from recipes";
    }

    @DeleteMapping("/remove/all")  // delete all recipes
    public String deleteRecipeByTitle(){
//        if (!recipeMap.containsKey(id)) {
//            throw new RecipeNotFoundException("Unable to delete recipe because id # " + id + " does not exist");
//        }
        recipeItemRepo.deleteAll();
        return "All Recipes were deleted";
    }

    // todo: exception handling

} // end RecipeManagementController
