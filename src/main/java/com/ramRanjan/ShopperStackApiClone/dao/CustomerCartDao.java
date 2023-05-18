package com.ramRanjan.ShopperStackApiClone.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ramRanjan.ShopperStackApiClone.entity.CustomerCart;
import com.ramRanjan.ShopperStackApiClone.repository.CustomerCartRepo;

@Repository
public class CustomerCartDao {
@Autowired
private CustomerCartRepo cartRepo;
public CustomerCart saveCustomerCart(CustomerCart cart) {
	return cartRepo.save(cart);
}
public CustomerCart updateCustomerCart(long cartId,CustomerCart cart) {
	if(cartRepo.findById(cartId).isPresent()) {
		cart.setCustomerCartId(cartId);
		return cartRepo.save(cart);
	}
	return null;
}
public CustomerCart findCart(long cartId) {
	if(cartRepo.findById(cartId).isPresent()) {
		return cartRepo.findById(cartId).get();
	}
	return null;
}
public CustomerCart deleteCart(long cartId) {
	if(cartRepo.findById(cartId).isPresent()) {
		CustomerCart cart= cartRepo.findById(cartId).get();
		cartRepo.delete(cart);
		return cart;
	}
	return null;
}
}
