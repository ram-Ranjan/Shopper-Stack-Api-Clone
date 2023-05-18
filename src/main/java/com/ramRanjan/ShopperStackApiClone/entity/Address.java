package com.ramRanjan.ShopperStackApiClone.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {
	@Id
	private long addressiD;
	private String buildingName;
	private String road;
	private String city;
	private String state;
	private String landMark;
	private String customerName;
	private long customerPhoneNumber;
	private long pincode;
	@ManyToOne
	private User user;

}
