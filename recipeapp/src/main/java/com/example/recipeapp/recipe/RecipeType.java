package com.example.recipeapp.recipe;

public class RecipeType {
	
	private String recipeTypeName;
	private String id;
	
	public RecipeType(String label, String value) {
		this.recipeTypeName = label;
		this.id = value;
	}

	public String getLabel() {
		return recipeTypeName;
	}

	public void setLabel(String label) {
		this.recipeTypeName = label;
	}

	public String getValue() {
		return id;
	}

	public void setValue(String value) {
		this.id = value;
	}
	
	


	
	
	
	

}
