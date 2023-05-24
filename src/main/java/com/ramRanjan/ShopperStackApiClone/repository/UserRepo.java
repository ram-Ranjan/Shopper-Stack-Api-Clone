package com.ramRanjan.ShopperStackApiClone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ramRanjan.ShopperStackApiClone.entity.User;

public interface UserRepo extends JpaRepository<User, Long>{
	
//	@Query("select u from user u")
	
	public List<User> findAll();

}
