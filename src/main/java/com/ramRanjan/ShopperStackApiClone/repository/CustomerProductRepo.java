package com.ramRanjan.ShopperStackApiClone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ramRanjan.ShopperStackApiClone.entity.CustomerProduct;

public interface CustomerProductRepo extends JpaRepository<CustomerProduct, Long> {

}
