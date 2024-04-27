package org.spring.recipemanagement;

import org.springframework.data.mongodb.repository.MongoRepository;

/*
 The API implementation happens in the repository.
 It acts as a link between the model and the database and has all the methods for CRUD operations.
  */

public interface RecipeItemRepository extends MongoRepository <Recipe, String> {

    public long count(); // count the number of documents in a collection
}
