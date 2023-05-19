package com.ramRanjan.ShopperStackApiClone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ramRanjan.ShopperStackApiClone.dto.CustomerCartDto;
import com.ramRanjan.ShopperStackApiClone.entity.CustomerCart;
import com.ramRanjan.ShopperStackApiClone.service.CustomerCartService;
import com.ramRanjan.ShopperStackApiClone.util.ResponseStructure;

@RestController
@RequestMapping("/cart")
public class CustomerCartController {
	@Autowired
	private CustomerCartService cartService;
	
	@PostMapping
public ResponseEntity<ResponseStructure<CustomerCart>> addCart(@RequestParam long productId,@RequestBody CustomerCartDto cartDto){
		return cartService.addCart(productId, cartDto);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<CustomerCart>> updateCart(@RequestParam long cartId,@RequestBody CustomerCartDto cartDto){
		return cartService.updateCart(cartId, cartDto);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<CustomerCart>> getCart(@RequestParam long cartId){
		return cartService.findCart(cartId);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<CustomerCart>> deleteCart(@RequestParam long cartId){
		return cartService.deleteCart(cartId);
	}

}
