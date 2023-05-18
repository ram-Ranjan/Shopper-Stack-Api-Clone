package com.ramRanjan.ShopperStackApiClone.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CustomerCart {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerCartId;
	private double customerCartSubTotal;
	private long customerCartQuantity;
	private double customerCartDiscount;
	private double customerCartTotal;
}
