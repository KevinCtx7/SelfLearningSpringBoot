package com.example.recipeapp.recipe;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class RecipeResource {
	
	private RecipeTypeService recipeTypeService;
	
	
	public RecipeResource(RecipeTypeService recipeTypeService) {
		this.recipeTypeService = recipeTypeService;
	}



	@GetMapping("/recipetypes")
	public List<RecipeType> retrieveAllRecipeType(){
		return recipeTypeService.findAll();
		
	}
	



}
