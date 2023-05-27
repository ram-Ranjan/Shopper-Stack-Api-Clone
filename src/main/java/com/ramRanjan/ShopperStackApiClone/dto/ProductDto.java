package com.ramRanjan.ShopperStackApiClone.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.ramRanjan.ShopperStackApiClone.enums.ProductSize;
import com.ramRanjan.ShopperStackApiClone.enums.ProductStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class ProductDto {

	private long productId;
	private String productTitle;
	private String productDescription;
	private double productPrice;
	private double productDiscount;
	private double discountedPrice;
	private LocalDate addedDate;
	private ProductSize productsize;
	private ProductStatus produtStatus;
	private double productStock;
	private int productQuantity;

	

}
