package com.ramRanjan.ShopperStackApiClone.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ramRanjan.ShopperStackApiClone.entity.User;
import com.ramRanjan.ShopperStackApiClone.repository.UserRepo;


@Repository
public class UserDao {
	@Autowired
	private UserRepo repo;
	
	public User saveUser(User user) {
		return repo.save(user);
	}
	public User updateUser(long userId,User user) {
		if(repo.findById(userId).isPresent()) {
			user.setUserId(userId);
			return repo.save(user);
		}
		return null;
	}
	public User findUserById(long userId) {
		if(repo.findById(userId).isPresent()) {
			return repo.findById(userId).get();
		}return null;
	}
	public User deleteUser(long userId) {
		if(repo.findById(userId).isPresent()) {
			User user=repo.findById(userId).get();
			repo.delete(user);
			return user;
		}
		return null;
	}
}
