package com.ramRanjan.ShopperStackApiClone.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.data.annotation.CreatedDate;

import com.ramRanjan.ShopperStackApiClone.enums.ProductSize;
import com.ramRanjan.ShopperStackApiClone.enums.ProductStatus;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	private String productTitle;
	private String productDescription;
	private double productPrice;
	private double productDiscount;
	@CreatedDate
	private LocalDate addedDate;
	private ProductSize productSize;
	private ProductStatus productStatus;
	private double productStock;
	
	@ManyToMany
	private List<User> listOfUsers;
	@ManyToMany
	private List<ProductReview> productReviews;
	

}
