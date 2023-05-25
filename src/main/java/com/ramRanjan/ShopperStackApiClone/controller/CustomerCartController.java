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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/cart")
public class CustomerCartController {
	@Autowired
	private CustomerCartService cartService;
	
	@ApiOperation(value = "Save Cart", notes = " Api is used to save the Cart")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully created"),
			@ApiResponse(code = 404, message = "Cart not found for the given  id") })
	@PostMapping
public ResponseEntity<ResponseStructure<CustomerCart>> addCart(@RequestParam long userId,@RequestParam long productId,@RequestBody CustomerCartDto cartDto){
		return cartService.addCart(userId, productId, cartDto);
	}
	@ApiOperation(value = "Update Cart", notes = " Api is used to update the Cart")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Updated"),
			@ApiResponse(code = 404, message = "Cart not found for the given  id") })
	@PutMapping
	public ResponseEntity<ResponseStructure<CustomerCart>> updateCart(@RequestParam long cartId,@RequestBody CustomerCartDto cartDto){
		return cartService.updateCart(cartId, cartDto);
	}
	@ApiOperation(value = "Find Cart", notes = " Api is used to find the Cart")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Successfully fetched"),
			@ApiResponse(code = 404, message = "Cart not found for the given  id") })
	@GetMapping
	public ResponseEntity<ResponseStructure<CustomerCart>> getCart(@RequestParam long cartId){
		return cartService.findCart(cartId);
	}

	@ApiOperation(value = "Delete Cart", notes = " Api is used to delete the Cart")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully deleted"),
			@ApiResponse(code = 404, message = "Cart not found for the given  id") })
	@DeleteMapping
	public ResponseEntity<ResponseStructure<CustomerCart>> deleteCart(@RequestParam long cartId){
		return cartService.deleteCart(cartId);
	}

}
