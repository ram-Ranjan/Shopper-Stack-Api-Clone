package com.ramRanjan.ShopperStackApiClone.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class CustomerCart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerCartId;
	private double customerCartSubTotal;
	private long customerCartQuantity;
	private double customerCartDiscount;
	private double customerCartTotal;
	@OneToMany
	private List<CustomerOrder> customerOrders;
}
