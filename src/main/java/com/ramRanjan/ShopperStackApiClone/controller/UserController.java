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
import com.ramRanjan.ShopperStackApiClone.enums.UserRole;
import com.ramRanjan.ShopperStackApiClone.enums.UserStatus;
import com.ramRanjan.ShopperStackApiClone.service.UserService;
import com.ramRanjan.ShopperStackApiClone.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/user")
public class UserController {
@Autowired
private UserService userService;

@ApiOperation(value = "Save User", notes = " Api is used to save the User")
@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully created"),
		@ApiResponse(code = 404, message = "User not found for the given  id") })
@PostMapping
public ResponseEntity<ResponseStructure<UserDto>> addUser(@RequestBody User user){
	return userService.addUser(user);
}
@ApiOperation(value = "Update User", notes = " Api is used to update the User")
@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Updated"),
		@ApiResponse(code = 404, message = "User not found for the given  id") })
@PutMapping
public ResponseEntity<ResponseStructure<UserDto>> updateUser(@RequestParam long userId ,@RequestBody User user){
	return userService.updateUser(userId, user);
}

@ApiOperation(value = "Update User Status", notes = " Api is used to update the User Status")
@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Updated"),
		@ApiResponse(code = 404, message = "User not found for the given  id") })
@PutMapping("/userStatus")
public ResponseEntity<ResponseStructure<UserDto>> updateUserStatus(@RequestParam long userId ,@RequestParam UserStatus userStatus,@RequestParam UserRole userRole){
	return userService.updateUserStatus(userId, userStatus,userRole);
}

@ApiOperation(value = "Find User", notes = " Api is used to find the User")
@ApiResponses(value = { @ApiResponse(code = 302, message = "Successfully fetched"),
		@ApiResponse(code = 404, message = "User not found for the given  id") })
@GetMapping
public ResponseEntity<ResponseStructure<UserDto>> findUser(@RequestParam long userId){
	return userService.findUserById(userId);
}

@ApiOperation(value = "Delete User", notes = " Api is used to delete the User")
@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully deleted"),
		@ApiResponse(code = 404, message = "User not found for the given  id") })
@DeleteMapping
public ResponseEntity<ResponseStructure<UserDto>> deleteUser(@RequestParam long userId){
	return userService.deleteUserById(userId);
}


}
