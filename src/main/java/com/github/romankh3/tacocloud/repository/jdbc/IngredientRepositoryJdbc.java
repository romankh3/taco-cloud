package com.github.romankh3.tacocloud.repository.jdbc;

import com.github.romankh3.tacocloud.Ingredient;

public interface IngredientRepositoryJdbc {
    Iterable<Ingredient> findAll();
    Ingredient findOne(String id);
    Ingredient save(Ingredient ingredient);
}
