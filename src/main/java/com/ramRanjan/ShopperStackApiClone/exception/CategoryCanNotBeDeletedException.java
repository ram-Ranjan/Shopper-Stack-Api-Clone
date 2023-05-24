package com.ramRanjan.ShopperStackApiClone.exception;

import lombok.Getter;

@Getter
public class CategoryCanNotBeDeletedException extends RuntimeException {

	private String message;

	public CategoryCanNotBeDeletedException(String message) {

		this.message = message;
	}
}
