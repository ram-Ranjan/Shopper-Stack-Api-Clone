package com.ramRanjan.ShopperStackApiClone.exception;

import lombok.Getter;

@Getter
public class AddressIdNotFoundException extends Exception {
private String message;

public AddressIdNotFoundException(String message) {
	
	this.message = message;
}

}
