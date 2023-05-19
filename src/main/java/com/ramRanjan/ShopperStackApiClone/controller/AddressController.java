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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@ApiOperation(value = "Save Address", notes = " Api is used to save the address")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully created"),
			@ApiResponse(code = 404, message = "Address not found for the given  id") })
	@PostMapping
public ResponseEntity<ResponseStructure<Address>> addAddress(@RequestParam long userId,@RequestBody AddressDto addressDto){
		return addressService.saveAddress(userId, addressDto);
	}
	@ApiOperation(value = "Update Address", notes = " Api is used to update the address")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Updated"),
			@ApiResponse(code = 404, message = "Address not found for the given  id") })
	@PutMapping
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestParam long addressId,@RequestBody AddressDto addressDto){
		return addressService.updateAddress(addressId, addressDto);
	}

	@ApiOperation(value = "Find Address", notes = " Api is used to find the address")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Successfully fetched"),
			@ApiResponse(code = 404, message = "Address not found for the given  id") })
	@GetMapping
	public ResponseEntity<ResponseStructure<Address>> getAddress(@RequestParam long addressId){
		return addressService.findAddress(addressId);
	}

	@ApiOperation(value = "Delete Address", notes = " Api is used to delete the address")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully deleted"),
			@ApiResponse(code = 404, message = "Address not found for the given  id") })
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(@RequestParam long addressId){
		return addressService.deleteAddress(addressId);
	}

	
}
