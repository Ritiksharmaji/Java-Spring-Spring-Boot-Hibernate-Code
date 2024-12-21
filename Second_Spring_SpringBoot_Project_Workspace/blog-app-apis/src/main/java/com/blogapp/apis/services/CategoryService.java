package com.blogapp.apis.services;

import java.util.List;
import com.blogapp.apis.payloads.CategoryDto;

public interface CategoryService {
	
	// create 
	public CategoryDto CreateCategory(CategoryDto categoryDto);
	
	// update 
	public CategoryDto UpdateCategory(CategoryDto categoryDto, Integer categoryId);
	
	// get a single data
	public CategoryDto GetACategory(Integer categoryId);
	// get all data
	public List<CategoryDto> GetAllCategory();
	
	// delete a data
	public void DeleteACategory(Integer categoryId);
}

