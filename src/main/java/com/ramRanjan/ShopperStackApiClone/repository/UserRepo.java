package com.ramRanjan.ShopperStackApiClone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ramRanjan.ShopperStackApiClone.entity.User;
import com.ramRanjan.ShopperStackApiClone.enums.UserRole;

public interface UserRepo extends JpaRepository<User, Long>{
	

	@Query("select u from User u where u.userRole=?1")
	public List<User> findAllUsers(UserRole userRole);

}
