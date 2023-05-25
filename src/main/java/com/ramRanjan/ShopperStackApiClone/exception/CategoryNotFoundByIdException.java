package com.ramRanjan.ShopperStackApiClone.exception;

import lombok.Getter;

@Getter
public class CategoryNotFoundByIdException extends RuntimeException {

	
	private String message;

	public CategoryNotFoundByIdException(String message) {

		this.message = message;
	}
}
