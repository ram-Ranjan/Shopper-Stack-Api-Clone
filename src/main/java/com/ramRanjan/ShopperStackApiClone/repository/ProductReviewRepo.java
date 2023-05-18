package com.ramRanjan.ShopperStackApiClone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ramRanjan.ShopperStackApiClone.entity.ProductReview;

public interface ProductReviewRepo extends JpaRepository<ProductReview, Long> {

}
