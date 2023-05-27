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

import com.ramRanjan.ShopperStackApiClone.dto.CustomerProductDto;
import com.ramRanjan.ShopperStackApiClone.dto.ProductDto;
import com.ramRanjan.ShopperStackApiClone.service.CustomerProductService;
import com.ramRanjan.ShopperStackApiClone.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/product")
public class CustomerProductController {

	@Autowired
	CustomerProductService productService;
	
	@ApiOperation(value = "Save Customer Product", notes = " Api is used to save the Customer Product")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully created"),
			@ApiResponse(code = 404, message = "Customer Product not found for the given  id") })
	@PostMapping
	public ResponseEntity<ResponseStructure<CustomerProductDto>> addCustomerProduct(@RequestParam long userId,@RequestParam long categoryId,
			@RequestBody ProductDto productDto) {
		return productService.addProduct(userId, categoryId, productDto);
	}

	@ApiOperation(value = "Find Customer Product", notes = " Api is used to find the Customer Product")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Successfully fetched"),
			@ApiResponse(code = 404, message = "Customer Product not found for the given  id") })
	@GetMapping
	public ResponseEntity<ResponseStructure<CustomerProductDto>> getProductById(@RequestParam long productId) {
		return productService.getCustomerProductById(productId);
	}
	@ApiOperation(value = "Update Customer Product", notes = " Api is used to update the Customer Product")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Updated"),
			@ApiResponse(code = 404, message = "Customer Product not found for the given  id") })
	@PutMapping
	public ResponseEntity<ResponseStructure<CustomerProductDto>> updateProduct(@RequestParam long userId,@RequestParam long productId,@RequestBody ProductDto productDto) {
		return productService.updateCustomerProduct(userId,productId, productDto);

	}
	@ApiOperation(value = "Delete Customer Product", notes = " Api is used to delete the Customer Product")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully deleted"),
			@ApiResponse(code = 404, message = "Customer Product not found for the given  id") })
	@DeleteMapping
	public ResponseEntity<ResponseStructure<CustomerProductDto>> deleteProduct(long productId){
		return productService.deleteCustomerProductById(productId);
	}
}
