package com.ramRanjan.ShopperStackApiClone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ramRanjan.ShopperStackApiClone.entity.CustomerOrder;

public interface CustomerOrderRepo extends JpaRepository<CustomerOrder, Long>{

}
