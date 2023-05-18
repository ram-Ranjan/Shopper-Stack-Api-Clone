package com.ramRanjan.ShopperStackApiClone.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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
	private LocalDate addedDate;
	private ProductSize productsize;
	private ProductStatus produtStatus;
	private double productStock;
	@ManyToOne
	private List<User> users;
	@ManyToMany
	private List<ProductReview> productReviews;
	@ManyToMany
	private List<CustomerCart> carts;
	
	

}
