package com.ramRanjan.ShopperStackApiClone.exception;

import lombok.Getter;

@Getter
public class OrderIdNotFoundException extends RuntimeException {
private String message;

public OrderIdNotFoundException(String message) {

	this.message = message;
}

}
