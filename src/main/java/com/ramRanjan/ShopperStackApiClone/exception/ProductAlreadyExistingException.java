package com.ramRanjan.ShopperStackApiClone.exception;

import lombok.Getter;

@Getter
public class ProductAlreadyExistingException extends RuntimeException {

	private String message;

	public ProductAlreadyExistingException(String message) {
		this.message = message;
	}
}
