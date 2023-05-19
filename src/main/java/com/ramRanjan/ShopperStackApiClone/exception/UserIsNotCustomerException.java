package com.ramRanjan.ShopperStackApiClone.exception;

import lombok.Getter;

@Getter
public class UserIsNotCustomerException extends RuntimeException {

	private String message;

	public UserIsNotCustomerException(String message) {
		this.message = message;
	}
}
