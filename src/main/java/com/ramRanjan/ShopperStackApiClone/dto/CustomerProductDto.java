package com.ramRanjan.ShopperStackApiClone.dto;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class CustomerProductDto {

	private long productId;
	private int productQuantity;
}