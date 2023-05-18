package com.ramRanjan.ShopperStackApiClone.dto;

import org.springframework.stereotype.Component;

import com.ramRanjan.ShopperStackApiClone.enums.UserRole;
import com.ramRanjan.ShopperStackApiClone.enums.UserStatus;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class UserDto {
	private long userId;
	private String userName;
	private String userEmail;
	private String userPassword;
	private long userPhoneNumber;
	private UserRole userRole;
	private UserStatus userStatus;
	
}
