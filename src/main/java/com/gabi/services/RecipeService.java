package com.gabi.services;

import com.gabi.commands.RecipeCommand;
import com.gabi.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipies();

    Recipe findById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    RecipeCommand findCommandById(Long l);

    void deleteById(Long id);
}
