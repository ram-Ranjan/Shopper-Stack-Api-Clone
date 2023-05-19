package com.ramRanjan.ShopperStackApiClone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ramRanjan.ShopperStackApiClone.dto.ProductDto;
import com.ramRanjan.ShopperStackApiClone.service.ProductService;
import com.ramRanjan.ShopperStackApiClone.util.ResponseStructure;

public class ProductController {

	@Autowired
	ProductService productService;

	public ResponseEntity<ResponseStructure<ProductDto>> addProduct(@RequestParam long userId,
			@RequestBody ProductDto productDto) {
		return productService.addProduct(userId, productDto);
	}

	public ResponseEntity<ResponseStructure<ProductDto>> getProductById(@RequestParam long productId) {
		return productService.getProductById(productId);
	}

	public ResponseEntity<ResponseStructure<ProductDto>> updateProduct(long productId, ProductDto productDto) {
		return productService.updateProduct(productId, productDto);

	}
	public ResponseEntity<ResponseStructure<ProductDto>> deleteProduct(long productId){
		return productService.deleteProductById(productId);
	}
}
