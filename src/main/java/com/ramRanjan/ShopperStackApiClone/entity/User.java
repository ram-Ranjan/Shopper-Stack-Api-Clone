package com.ramRanjan.ShopperStackApiClone.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.ramRanjan.ShopperStackApiClone.enums.UserRole;
import com.ramRanjan.ShopperStackApiClone.enums.UserStatus;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	@ApiModelProperty(required = true)
	private String userName;
	@ApiModelProperty(required = true)
	private String userEmail;
	@ApiModelProperty(required = true)
	private String userPassword;
	@ApiModelProperty(required = true)
	private long userPhoneNumber;
	@ApiModelProperty(required = true)
	private UserRole userRole;
	@ApiModelProperty(required = true)
	private UserStatus userStatus;
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	List<Address> addresses;
	@OneToMany(mappedBy = "listOfUsers",cascade = CascadeType.ALL)
	List<Product> products;
	@OneToOne
	private CustomerCart cart;
	@OneToMany(mappedBy = "user")
	List<Wishlist> wishlists;
}
