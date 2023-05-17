package com.ramRanjan.ShopperStackApiClone.util;

import lombok.Data;

@Data
public class ResponseStructure<T> {
	
	private int status;
	private String message;
	private Object data;
	
	
	
}
 