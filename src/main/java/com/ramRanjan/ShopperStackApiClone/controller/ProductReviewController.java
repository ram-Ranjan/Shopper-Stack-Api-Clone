package com.ramRanjan.ShopperStackApiClone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ramRanjan.ShopperStackApiClone.dto.ProductReviewDto;
import com.ramRanjan.ShopperStackApiClone.service.ProductReviewService;
import com.ramRanjan.ShopperStackApiClone.util.ResponseStructure;

public class ProductReviewController {

	@Autowired
	ProductReviewService productReviewService;

	public ResponseEntity<ResponseStructure<ProductReviewDto>> addProductReview(@RequestParam long userId,
			@RequestParam long productId, @RequestBody ProductReviewDto productReviewDto) {
		return productReviewService.addProductReview(userId, productId, productReviewDto);
	}

	public ResponseEntity<ResponseStructure<ProductReviewDto>> getProductReviewById(
			@RequestParam long productReviewId) {
		return productReviewService.getProductReviewById(productReviewId);
	}

	public ResponseEntity<ResponseStructure<ProductReviewDto>> updateProductReview(long productReviewId,
			ProductReviewDto productReviewDto) {
		return productReviewService.updateProductReview(productReviewId, productReviewDto);

	}

	public ResponseEntity<ResponseStructure<ProductReviewDto>> deleteProductReviewById(long productReviewId) {
		return productReviewService.deleteProductReviewById(productReviewId);
	}
}
