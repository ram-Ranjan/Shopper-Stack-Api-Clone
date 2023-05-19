package com.ramRanjan.ShopperStackApiClone.exception;

import lombok.Getter;

@Getter
public class UserNotFoundByIdException extends RuntimeException {

	private String message;

	public UserNotFoundByIdException(String message) {
		this.message = message;
	}
}
