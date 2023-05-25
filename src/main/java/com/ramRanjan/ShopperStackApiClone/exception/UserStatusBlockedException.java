package com.ramRanjan.ShopperStackApiClone.exception;

import lombok.Getter;

@Getter
public class UserStatusBlockedException extends RuntimeException {

	private String message;

	public UserStatusBlockedException(String message) {
		this.message = message;
	}

}
