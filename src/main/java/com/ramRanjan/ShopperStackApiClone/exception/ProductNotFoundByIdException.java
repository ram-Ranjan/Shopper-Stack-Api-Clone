package com.ramRanjan.ShopperStackApiClone.exception;

import lombok.Getter;

@Getter
public class ProductNotFoundByIdException extends RuntimeException {

	private String message;

	public ProductNotFoundByIdException(String message) {
		this.message = message;
	}
}
