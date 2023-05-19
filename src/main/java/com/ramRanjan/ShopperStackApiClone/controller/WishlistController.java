package com.ramRanjan.ShopperStackApiClone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ramRanjan.ShopperStackApiClone.dto.WishlistDto;
import com.ramRanjan.ShopperStackApiClone.service.WishlistService;
import com.ramRanjan.ShopperStackApiClone.util.ResponseStructure;

public class WishlistController {

	@Autowired
	WishlistService wishlistService;

	public ResponseEntity<ResponseStructure<WishlistDto>> addWishlist(@RequestParam long userId,@RequestParam long productId,
			@RequestBody WishlistDto wishlistDto) {
		return wishlistService.addWishlist(userId,productId, wishlistDto);
	}

	public ResponseEntity<ResponseStructure<WishlistDto>> getWishlistById(@RequestParam long wishlistId) {
		return wishlistService.getWishlistById(wishlistId);
	}

	public ResponseEntity<ResponseStructure<WishlistDto>> updateWishlist(long wishlistId, WishlistDto wishlistDto) {
		return wishlistService.updateWishlist(wishlistId, wishlistDto);

	}
	public ResponseEntity<ResponseStructure<WishlistDto>> deleteWishlistById(long wishlistId){
		return wishlistService.deleteWishlistById(wishlistId);
	}
}
