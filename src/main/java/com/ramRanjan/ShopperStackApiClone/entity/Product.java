package com.ramRanjan.ShopperStackApiClone.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long productId;
	String productTitle;
	String productDescription;
	double productPrice;
	double productDiscount;
	
	

}
