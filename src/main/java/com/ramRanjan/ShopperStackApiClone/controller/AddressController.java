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

import com.ramRanjan.ShopperStackApiClone.dto.AddressDto;
import com.ramRanjan.ShopperStackApiClone.entity.Address;
import com.ramRanjan.ShopperStackApiClone.service.AddressService;
import com.ramRanjan.ShopperStackApiClone.util.ResponseStructure;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@PostMapping
public ResponseEntity<ResponseStructure<Address>> addAddress(@RequestParam long userId,@RequestBody AddressDto addressDto){
		return addressService.saveAddress(userId, addressDto);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestParam long addressId,@RequestBody AddressDto addressDto){
		return addressService.updateAddress(addressId, addressDto);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<Address>> getAddress(@RequestParam long addressId){
		return addressService.findAddress(addressId);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(@RequestParam long addressId){
		return addressService.deleteAddress(addressId);
	}

	
}
