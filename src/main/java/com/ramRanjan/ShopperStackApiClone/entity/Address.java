package com.ramRanjan.ShopperStackApiClone.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long addressId;
	private String buildingName;
	private String road;
	private String city;
	private String state;
	private String landMark;
	private String customerName;
	private long customerPhoneNumber;
	private long pincode;
	@ManyToOne
	@JsonIgnore
	private User user;

}
