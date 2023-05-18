package com.ramRanjan.ShopperStackApiClone.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.ramRanjan.ShopperStackApiClone.enums.UserRole;
import com.ramRanjan.ShopperStackApiClone.enums.UserStatus;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	private String userName;
	private String userEmail;
	private String userPassword;
	private long userPhoneNumber;
	private UserRole userRole;
	private UserStatus userStatus;
	@OneToMany
	List<Address> addresses;
	@ManyToMany
	List<Product> products;
	@OneToOne
	private CustomerCart cart;
	@OneToMany
	List<Wishlist> wishlists;
}
