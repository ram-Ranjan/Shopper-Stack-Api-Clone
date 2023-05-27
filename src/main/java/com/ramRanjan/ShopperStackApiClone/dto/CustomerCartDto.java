package com.ramRanjan.ShopperStackApiClone.dto;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class CustomerCartDto {
	private long customerCartId;
	private double customerCartSubTotal;
	private double customerCartDiscount;
	private double customerCartTotal;
}
