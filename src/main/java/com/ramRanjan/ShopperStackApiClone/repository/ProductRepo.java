package com.ramRanjan.ShopperStackApiClone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ramRanjan.ShopperStackApiClone.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
