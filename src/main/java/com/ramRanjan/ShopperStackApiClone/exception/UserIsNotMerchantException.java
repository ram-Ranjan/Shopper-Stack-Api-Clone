package com.ramRanjan.ShopperStackApiClone.exception;

import lombok.Getter;

@Getter
public class UserIsNotMerchantException extends RuntimeException {

	private String message;

	public UserIsNotMerchantException(String message) {
		this.message = message;
	}
}
