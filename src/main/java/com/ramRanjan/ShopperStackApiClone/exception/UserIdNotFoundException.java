package com.ramRanjan.ShopperStackApiClone.exception;

import lombok.Getter;

@Getter
public class UserIdNotFoundException extends RuntimeException {
	private String message;

	public UserIdNotFoundException(String message) {
		
		this.message = message;
	}
}
