package com.gabi.controllers;

import com.gabi.commands.RecipeCommand;
import com.gabi.domain.Recipe;
import com.gabi.exceptions.NotFoundException;
import com.gabi.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class RecipeControllerTest {
    @Mock
    RecipeService recipeService;

    RecipeController recipeController;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        recipeController = new RecipeController(recipeService );
    }

    @Test
    public void testGetRecipe() throws Exception{

        Recipe recipe = new Recipe();
        recipe.setId(1L);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();

        when(recipeService.findById(anyLong())).thenReturn(recipe);

        mockMvc.perform(get("/recipe/1/show"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/show"));
    }

    @Test
    public void testGetRecipeNotFound() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        when(recipeService.findById(anyLong())).thenThrow(NotFoundException.class);

        mockMvc.perform(get("/recipe/1/show"))
                .andExpect(status().isNotFound());
    }
//
//    @Test
//    public void testPostNewRecipeFormValidationFail() throws Exception{
//        RecipeCommand command = new RecipeCommand();
//        command.setId(2L);
//
//        when(recipeService.saveRecipeCommand(any())).thenReturn(command);
//
//        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();
//        mockMvc.perform(post("/recipe")
//                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
//                .param("id", "")
//                .param("description", "some string")
//                .param("directions", "some directions")
//        )
////                .andExpect(status().is3xxRedirection())
//                .andExpect(model().attributeExists("recipe"))
//                .andExpect(view().name("recipe/recipeform"));
//
//    }
}
