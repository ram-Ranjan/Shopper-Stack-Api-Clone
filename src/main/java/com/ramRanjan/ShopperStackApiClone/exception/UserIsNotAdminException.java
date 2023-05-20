package com.ramRanjan.ShopperStackApiClone.exception;

import lombok.Getter;

@Getter
public class UserIsNotAdminException extends RuntimeException {

	private String message;

	public UserIsNotAdminException(String message) {
		this.message = message;
	}
}
