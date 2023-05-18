package com.ramRanjan.ShopperStackApiClone.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ramRanjan.ShopperStackApiClone.entity.ProductReview;
import com.ramRanjan.ShopperStackApiClone.repository.ProductReviewRepo;

@Repository
public class ProductReviewDao {
	
	@Autowired
	ProductReviewRepo productReviewRepo;
	
	public ProductReview addProductReview(ProductReview productReview){
		return productReviewRepo.save(productReview);
	}
	
	public ProductReview getProductReviewById(long id) {
		Optional<ProductReview> optional = productReviewRepo.findById(id);
		if(optional.isPresent())
			return  optional.get();
		else
			return null;
		
	}
	
	public ProductReview updateProductReview(long id,ProductReview productReview) {
		Optional<ProductReview> optional =productReviewRepo.findById(id);
		if (optional.isPresent()) {
			productReview =productReviewRepo.save(productReview);
			return productReview;
		}
		else
			return null;
	}
	public ProductReview deleteProductReview(long id) {
		Optional<ProductReview> optional = productReviewRepo.findById(id);
		if(optional.isPresent()) {
			productReviewRepo.deleteById(id);
			return optional.get();
		}
		else
			return null;
	}

}
