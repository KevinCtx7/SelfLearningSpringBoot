package com.example.recipeapp.recipe;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class RecipeTypeService {
	private static List<RecipeType> recipeTypes = new ArrayList<>();
	
	static {
		recipeTypes.add(new RecipeType("Salad","Salad"));
		recipeTypes.add(new RecipeType("Mexican","Mexican"));
		recipeTypes.add(new RecipeType("Chinese","Chinese"));
	}
	
	public List<RecipeType> findAll(){
		return recipeTypes;
	}

}
