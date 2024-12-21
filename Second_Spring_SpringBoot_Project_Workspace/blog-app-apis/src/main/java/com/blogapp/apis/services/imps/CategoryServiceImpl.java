package com.blogapp.apis.services.imps;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blogapp.apis.entities.Category;
import com.blogapp.apis.exceptions.ResourceNotFoundException;
import com.blogapp.apis.payloads.CategoryDto;
import com.blogapp.apis.repositories.CategoryRepo;
import com.blogapp.apis.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public CategoryDto CreateCategory(CategoryDto categoryDto) {
		// TODO Auto-generated method stub
		/*
		 * mapping the CategoryDeto to Category object
		 */
		Category category_Mapped = this.modelMapper.map(categoryDto, Category.class);
		/*
		 * saving the Category object to database. by calling the save method of JPA throws 
		 * the categoryRepo object
		 */
		Category saveCategory = this.categoryRepo.save(category_Mapped);
		/*
		 * again changing the Category object to CategoryDto to send the Response.
		 */
		return this.modelMapper.map(saveCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto UpdateCategory(CategoryDto categoryDto, Integer categoryId) {
		// TODO Auto-generated method stub
		/*
		 * finding the old data to convert it new data 
		 */
		Category oldCategoryData = this.categoryRepo.findById(categoryId).
		orElseThrow(()->new ResourceNotFoundException("Category" , "Category Id",categoryId));
		/*
		 * setting new data
		 */
		oldCategoryData.setCategory_title(categoryDto.getCategory_title());
		oldCategoryData.setCategory_description(categoryDto.getCategory_description());
		/*
		 * saving the updated data to database
		 */
		Category newCategoryData = this.categoryRepo.save(oldCategoryData);
		
		return this.modelMapper.map(newCategoryData, CategoryDto.class);
	}

	@Override
	public CategoryDto GetACategory(Integer categoryId) {
		// TODO Auto-generated method stub
		/*
		 * getting a category data findById() method of JPA and send back to CategoryDto by
		 * converting it
		 */
		Category aCategoryData = this.categoryRepo.findById(categoryId).
		orElseThrow(()->new ResourceNotFoundException("Category" , "Category Id",categoryId));
		
		return this.modelMapper.map(aCategoryData, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> GetAllCategory() {
		// TODO Auto-generated method stub
		List<Category> all_CategoryData = this.categoryRepo.findAll();
		/*
		 * converting all the Category data to CategoryDto data by following
		 */
		List<CategoryDto> CategoryDtos = all_CategoryData.stream().map((category)->this.modelMapper.map(category, CategoryDto.class))
				.collect(Collectors.toList());
		return CategoryDtos;
	}

	@Override
	public void DeleteACategory(Integer categoryId) {
		// TODO Auto-generated method stub
		/*
		 * getting the data by categoryId then delete it
		 */
		Category categoryTODelete = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category" , "Category Id",categoryId));    
		this.categoryRepo.delete(categoryTODelete);

	}

}
