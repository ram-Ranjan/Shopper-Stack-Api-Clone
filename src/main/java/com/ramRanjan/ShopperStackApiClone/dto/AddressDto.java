package com.ramRanjan.ShopperStackApiClone.dto;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class AddressDto {

	private long addressiD;
	private String buildingName;
	private String road;
	private String city;
	private String state;
	private String landMark;
	private String customerName;
	private long customerPhoneNumber;
	private long pincode;
	

}
