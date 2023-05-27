package com.ramRanjan.ShopperStackApiClone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ramRanjan.ShopperStackApiClone.dto.ProductDto;
import com.ramRanjan.ShopperStackApiClone.service.ProductService;
import com.ramRanjan.ShopperStackApiClone.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@ApiOperation(value = "Save Product", notes = " Api is used to save the Product")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully created"),
			@ApiResponse(code = 404, message = "Product not found for the given  id") })
	@PostMapping
	public ResponseEntity<ResponseStructure<ProductDto>> addProduct(@RequestParam long userId,@RequestParam long categoryId,
			@RequestBody ProductDto productDto) {
		return productService.addProduct(userId, categoryId, productDto);
	}

	@ApiOperation(value = "Find Product", notes = " Api is used to find the Product")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Successfully fetched"),
			@ApiResponse(code = 404, message = "Product not found for the given  id") })
	@GetMapping
	public ResponseEntity<ResponseStructure<ProductDto>> getProductById(@RequestParam long productId) {
		return productService.getProductById(productId);
	}
	@ApiOperation(value = "Update Product", notes = " Api is used to update the Product")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Updated"),
			@ApiResponse(code = 404, message = "Product not found for the given  id") })
	@PutMapping
	public ResponseEntity<ResponseStructure<ProductDto>> updateProduct(@RequestParam long userId,@RequestParam long productId,@RequestBody ProductDto productDto) {
		return productService.updateProduct(userId,productId, productDto);

	}
	@ApiOperation(value = "Delete Product", notes = " Api is used to delete the Product")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully deleted"),
			@ApiResponse(code = 404, message = "Product not found for the given  id") })
	@DeleteMapping
	public ResponseEntity<ResponseStructure<ProductDto>> deleteProduct(long productId){
		return productService.deleteProductById(productId);
	}
}
