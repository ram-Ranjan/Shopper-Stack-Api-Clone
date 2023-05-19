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

import com.ramRanjan.ShopperStackApiClone.dto.WishlistDto;
import com.ramRanjan.ShopperStackApiClone.service.WishlistService;
import com.ramRanjan.ShopperStackApiClone.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
@RequestMapping("/wishlist")
public class WishlistController {

	@Autowired
	WishlistService wishlistService;

@ApiOperation(value = "Save WishList", notes = " Api is used to save the WishList")
@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully created"),
		@ApiResponse(code = 404, message = "WishList not found for the given  id") })
@PostMapping
	public ResponseEntity<ResponseStructure<WishlistDto>> addWishlist(@RequestParam long userId,@RequestParam long productId,
			@RequestBody WishlistDto wishlistDto) {
		return wishlistService.addWishlist(userId,productId, wishlistDto);
	}
	@ApiOperation(value = "Find WishList", notes = " Api is used to find the WishList")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Successfully fetched"),
			@ApiResponse(code = 404, message = "WishList not found for the given  id") })
	@GetMapping
	public ResponseEntity<ResponseStructure<WishlistDto>> getWishlistById(@RequestParam long wishlistId) {
		return wishlistService.getWishlistById(wishlistId);
	}
	@ApiOperation(value = "Update WishList", notes = " Api is used to update the WishList")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Updated"),
			@ApiResponse(code = 404, message = "WishList not found for the given  id") })
	@PutMapping
	public ResponseEntity<ResponseStructure<WishlistDto>> updateWishlist(long wishlistId, WishlistDto wishlistDto) {
		return wishlistService.updateWishlist(wishlistId, wishlistDto);

	}
	@ApiOperation(value = "Delete WishList", notes = " Api is used to delete the WishList")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully deleted"),
			@ApiResponse(code = 404, message = "WishList not found for the given  id") })
	@DeleteMapping
	public ResponseEntity<ResponseStructure<WishlistDto>> deleteWishlistById(long wishlistId){
		return wishlistService.deleteWishlistById(wishlistId);
	}
}
