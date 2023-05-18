package com.ramRanjan.ShopperStackApiClone.exception;

import lombok.Getter;

@Getter
public class WishlistNotFoundByIdException extends RuntimeException {

	private String message;

	public WishlistNotFoundByIdException(String message) {
		this.message = message;
	}
}
