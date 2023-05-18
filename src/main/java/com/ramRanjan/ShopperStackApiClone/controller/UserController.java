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

import com.ramRanjan.ShopperStackApiClone.dto.UserDto;
import com.ramRanjan.ShopperStackApiClone.entity.User;
import com.ramRanjan.ShopperStackApiClone.service.UserService;
import com.ramRanjan.ShopperStackApiClone.util.ResponseStructure;

@RestController
@RequestMapping("/user")
public class UserController {
@Autowired
private UserService userService;
@PostMapping
public ResponseEntity<ResponseStructure<UserDto>> addUser(@RequestBody User user){
	return userService.addUser(user);
}
@PutMapping
public ResponseEntity<ResponseStructure<UserDto>> updateUser(@RequestParam long userId ,@RequestBody User user){
	return userService.updateUser(userId, user);
}
@GetMapping
public ResponseEntity<ResponseStructure<UserDto>> findUser(@RequestParam long userId){
	return userService.findUserById(userId);
}
@DeleteMapping
public ResponseEntity<ResponseStructure<UserDto>> deleteUser(@RequestParam long userId){
	return userService.deleteUserById(userId);
}

}
