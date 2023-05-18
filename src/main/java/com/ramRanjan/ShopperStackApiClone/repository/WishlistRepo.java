package com.ramRanjan.ShopperStackApiClone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ramRanjan.ShopperStackApiClone.entity.Wishlist;

public interface WishlistRepo extends JpaRepository<Wishlist, Long> {

}
