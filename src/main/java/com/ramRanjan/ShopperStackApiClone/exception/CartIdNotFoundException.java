package com.ramRanjan.ShopperStackApiClone.exception;

import lombok.Getter;

@Getter
public class CartIdNotFoundException extends RuntimeException {
private String message;

public CartIdNotFoundException(String message) {
	this.message = message;
}

}
