package com.ramRanjan.ShopperStackApiClone.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ramRanjan.ShopperStackApiClone.enums.OrderStatus;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CustomerOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerOrderId;
	private LocalDateTime customerOrderDate;
	private OrderStatus orderStatus;
	private long productId;
	private String productTitle;
	private String productDescription;
	private double productPrice;
	private double productDiscount;
	private int customerCartQuantity;
	private double cartTotalPrice;
	
	}
	

