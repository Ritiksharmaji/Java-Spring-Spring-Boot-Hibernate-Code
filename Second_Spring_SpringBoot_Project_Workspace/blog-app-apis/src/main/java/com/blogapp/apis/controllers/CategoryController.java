package com.blogapp.apis.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blogapp.apis.payloads.ApiREsponse;
import com.blogapp.apis.payloads.CategoryDto;
import com.blogapp.apis.services.CategoryService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	// POST API
	@PostMapping("/createCategoryApi")
	public ResponseEntity<CategoryDto> creatUser( @Valid @RequestBody CategoryDto categoryDto){
		
		CategoryDto createCategory = this.categoryService.CreateCategory(categoryDto);
		// to send the client SMS
		return new ResponseEntity<CategoryDto>(createCategory, HttpStatus.CREATED) ;
		
	}
	// PUT API
	
	@PutMapping("/UpdateCategoryApi/{id}")
	public ResponseEntity<CategoryDto> UpdateUser( @Valid @RequestBody CategoryDto categoryDto,@PathVariable("id") int id){
		
		CategoryDto updateCategory = this.categoryService.UpdateCategory(categoryDto, id);
		
		return ResponseEntity.ok(updateCategory);
	}
	
	// DELELE DATA API
	
	@DeleteMapping("/DeleteCategoryApi/{categoryId}")
	public ResponseEntity<ApiREsponse> categoryDeleteApi(@PathVariable("categoryId") Integer uid){
		
		this.categoryService.DeleteACategory(uid);
	return new ResponseEntity<ApiREsponse>(new ApiREsponse("category Deleted successfully", true),HttpStatus.OK);
	}
	
	// GET ALL DATA API
	@GetMapping("/categoriesApi")
	public ResponseEntity<List<CategoryDto>> getAllcategories(){
		
		List<CategoryDto> getAllCategory = this.categoryService.GetAllCategory();
	return  ResponseEntity.ok(getAllCategory);
	}
	
	
	// GET A SINGLE DATA API
	@GetMapping("/categoryApi/{categoryId}")
	public ResponseEntity<CategoryDto> getcategory(@PathVariable("categoryId") Integer categoryId){
		
		  CategoryDto getACategory = this.categoryService.GetACategory(categoryId);
	
	return  ResponseEntity.ok(getACategory);
	}

}
