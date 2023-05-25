package com.ramRanjan.ShopperStackApiClone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ramRanjan.ShopperStackApiClone.dto.CategoryDto;
import com.ramRanjan.ShopperStackApiClone.entity.Category;
import com.ramRanjan.ShopperStackApiClone.service.CategoryService;
import com.ramRanjan.ShopperStackApiClone.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@ApiOperation(value = "Save Category", notes = " Api is used to save the Category")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully created"),
			@ApiResponse(code = 404, message = "Category not found for the given  id") })
	@PostMapping
	public ResponseEntity<ResponseStructure<CategoryDto>> addCategory(@RequestParam long userId, @RequestBody Category category) {
		return categoryService.addCategory(userId,category);
	}


	@ApiOperation(value = "Update Category", notes = " Api is used to update the Category")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Updated"),
			@ApiResponse(code = 404, message = "Category not found for the given  id") })
	@PutMapping
	public ResponseEntity<ResponseStructure<CategoryDto>> updateCategory(@RequestParam long categoryId,@RequestBody Category category) {
		return categoryService.updateCategory(categoryId, category);

	}
	@ApiOperation(value = "Delete Category", notes = " Api is used to delete the Category")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully deleted"),
			@ApiResponse(code = 404, message = "Category not found for the given  id") })
	@DeleteMapping
	public ResponseEntity<ResponseStructure<CategoryDto>> deleteCategory(long categoryId){
		return categoryService.deleteCategory(categoryId);
	}
}
