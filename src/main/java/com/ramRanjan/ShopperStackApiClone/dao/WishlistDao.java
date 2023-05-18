package com.ramRanjan.ShopperStackApiClone.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ramRanjan.ShopperStackApiClone.entity.Wishlist;
import com.ramRanjan.ShopperStackApiClone.repository.WishlistRepo;

@Repository
public class WishlistDao {
	
	@Autowired
	WishlistRepo wishlistRepo;
	
	public Wishlist addWishlist(Wishlist wishlist){
		return wishlistRepo.save(wishlist);
	}
	
	public Wishlist getWishlistById(long id) {
		Optional<Wishlist> optional = wishlistRepo.findById(id);
		if(optional.isPresent())
			return  optional.get();
		else
			return null;
		
	}
	
	public Wishlist updateWishlist(long id,Wishlist wishlist) {
		Optional<Wishlist> optional =wishlistRepo.findById(id);
		if (optional.isPresent()) {
			wishlist.setWishlistId(id);
			return wishlistRepo.save(wishlist);
			
		}
		else
			return null;
	}
	public Wishlist deleteProduct(long id) {
		Optional<Wishlist> optional = wishlistRepo.findById(id);
		if(optional.isPresent()) {
			wishlistRepo.deleteById(id);
			return optional.get();
		}
		else
			return null;
	}

}
