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

import com.ramRanjan.ShopperStackApiClone.dto.ProductReviewDto;
import com.ramRanjan.ShopperStackApiClone.service.ProductReviewService;
import com.ramRanjan.ShopperStackApiClone.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/review")
public class ProductReviewController {

	@Autowired
	ProductReviewService productReviewService;
	
	@ApiOperation(value = "Save Review", notes = " Api is used to save the Review")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully created"),
			@ApiResponse(code = 404, message = "Review not found for the given  id") })
	@PostMapping
	public ResponseEntity<ResponseStructure<ProductReviewDto>> addProductReview(@RequestParam long userId,
			@RequestParam long productId, @RequestBody ProductReviewDto productReviewDto) {
		return productReviewService.addProductReview(userId, productId, productReviewDto);
	}
	@ApiOperation(value = "Find Review", notes = " Api is used to find the Review")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Successfully fetched"),
			@ApiResponse(code = 404, message = "Review not found for the given  id") })
	@GetMapping
	public ResponseEntity<ResponseStructure<ProductReviewDto>> getProductReviewById(
			@RequestParam long productReviewId) {
		return productReviewService.getProductReviewById(productReviewId);
	}
	@ApiOperation(value = "Update Review", notes = " Api is used to update the Review")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Updated"),
			@ApiResponse(code = 404, message = "Review not found for the given  id") })
	@PutMapping
	public ResponseEntity<ResponseStructure<ProductReviewDto>> updateProductReview(long productReviewId,
			ProductReviewDto productReviewDto) {
		return productReviewService.updateProductReview(productReviewId, productReviewDto);

	}
	@ApiOperation(value = "Delete Review", notes = " Api is used to delete the Review")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully deleted"),
			@ApiResponse(code = 404, message = "Review not found for the given  id") })
	@DeleteMapping
	public ResponseEntity<ResponseStructure<ProductReviewDto>> deleteProductReviewById(long productReviewId) {
		return productReviewService.deleteProductReviewById(productReviewId);
	}
}
