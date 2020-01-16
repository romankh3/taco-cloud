package com.github.romankh3.tacocloud.repository.jpa;

import com.github.romankh3.tacocloud.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepositoryJpa extends CrudRepository<Ingredient, String> {
}
