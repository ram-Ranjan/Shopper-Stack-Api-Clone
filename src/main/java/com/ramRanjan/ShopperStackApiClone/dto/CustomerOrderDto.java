package com.ramRanjan.ShopperStackApiClone.dto;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class CustomerOrderDto {
	private long customerOrderId;
	private LocalDateTime customerOrderDate;
	private String customerOrderStatus;
	private long productId;
	private String productTitle;
	private String productDescription;
	private double productPrice;
	private double productDiscount;
	private int customerCartQuantity;
	private double cartTotalPrice;
	

}
