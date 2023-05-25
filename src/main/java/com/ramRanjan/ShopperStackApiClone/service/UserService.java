package com.ramRanjan.ShopperStackApiClone.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ramRanjan.ShopperStackApiClone.dao.UserDao;
import com.ramRanjan.ShopperStackApiClone.dto.UserDto;
import com.ramRanjan.ShopperStackApiClone.entity.User;
import com.ramRanjan.ShopperStackApiClone.enums.UserRole;
import com.ramRanjan.ShopperStackApiClone.enums.UserStatus;
import com.ramRanjan.ShopperStackApiClone.exception.UserIdNotFoundException;
import com.ramRanjan.ShopperStackApiClone.util.ResponseStructure;

@Service
public class UserService {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private UserDao userDao;
	
	public ResponseEntity<ResponseStructure<UserDto>> addUser(User user) {

			if(user.getUserRole().equals(UserRole.ADMIN)) {
				List<User>  users=  userDao.getAllUsers(UserRole.ADMIN);
				if(users.size()>1) {
					user.setUserStatus(UserStatus.BLOCKED);
				}
				else
					user.setUserStatus(UserStatus.APPROVED);	
			}
			else if(user.getUserRole().equals(UserRole.MERCHANT)) {	
					user.setUserStatus(UserStatus.BLOCKED);	
			}
			else
				user.setUserStatus(UserStatus.APPROVED);
		    User savedUser = userDao.saveUser(user);	
			UserDto userDto = this.modelMapper.map(savedUser, UserDto.class);
			userDto.setAddresses(savedUser.getAddresses());
			
			ResponseStructure<UserDto> structure = new ResponseStructure<UserDto>();
			structure.setMessage("User added successfully");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(userDto);
			return new ResponseEntity<ResponseStructure<UserDto>>(structure, HttpStatus.CREATED);
		
}
	public ResponseEntity<ResponseStructure<UserDto>> updateUser(long userId, User user) {
		
		
		User dbUser = userDao.findUserById(userId);
		if (dbUser != null && dbUser.getUserRole().equals(user.getUserRole())) {
			dbUser =userDao.saveUser(user);
			UserDto userDto = this.modelMapper.map(dbUser, UserDto.class);
			userDto.setAddresses(dbUser.getAddresses());

			ResponseStructure<UserDto> structure = new ResponseStructure<UserDto>();
			structure.setMessage("User updqated successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(userDto);
			return new ResponseEntity<ResponseStructure<UserDto>>(structure, HttpStatus.OK);
		} else {
			throw new UserIdNotFoundException("Failed to find User!!!");
		}
	}
	
	public ResponseEntity<ResponseStructure<UserDto>> updateUserStatus(long userId, UserStatus userStatus, UserRole userRole) {
		
		
		User dbUser = userDao.findUserById(userId);
		if (dbUser != null && userRole.equals(UserRole.ADMIN)) {
			dbUser.setUserStatus(UserStatus.APPROVED);
			dbUser =userDao.saveUser(dbUser);
			UserDto userDto = this.modelMapper.map(dbUser, UserDto.class);

			ResponseStructure<UserDto> structure = new ResponseStructure<UserDto>();
			structure.setMessage("User updqated successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(userDto);
			return new ResponseEntity<ResponseStructure<UserDto>>(structure, HttpStatus.OK);
		} else {
			throw new UserIdNotFoundException("Only Admin can update Role!!!");
		}
	}
	

	public ResponseEntity<ResponseStructure<UserDto>> findUserById(long userId) {
		User dbUser = userDao.findUserById(userId);
		if (dbUser != null) {
			
			UserDto userDto = this.modelMapper.map(dbUser, UserDto.class);
			userDto.setAddresses(dbUser.getAddresses());
			ResponseStructure<UserDto> structure = new ResponseStructure<UserDto>();
			structure.setMessage("User fetched successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(userDto);
			return new ResponseEntity<ResponseStructure<UserDto>>(structure, HttpStatus.OK);
		} else {
			throw new UserIdNotFoundException("Failed to Find User!!!");
		}
	}

	public ResponseEntity<ResponseStructure<UserDto>> deleteUserById(long userId) {
		User dbUser = userDao.findUserById(userId);
		if (dbUser != null) {
			UserDto userDto = this.modelMapper.map(dbUser, UserDto.class);
			ResponseStructure<UserDto> structure = new ResponseStructure<UserDto>();
			structure.setMessage("User deleted successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(userDto);
			return new ResponseEntity<ResponseStructure<UserDto>>(structure, HttpStatus.OK);
		} else {
			throw new UserIdNotFoundException("Failed to Find User!!!");
		}
	}
	
	
	public ResponseEntity<ResponseStructure<UserDto>> getAllUsers(UserRole  userRole) {
		List<User> dbUsers = userDao.getAllUsers(userRole);
		if (dbUsers != null) {
			
			List<UserDto> userDtos= new ArrayList<>();
			for(User u : dbUsers) {
			UserDto userDto = this.modelMapper.map(u, UserDto.class);
			userDtos.add(userDto);
			}
			ResponseStructure<UserDto> structure = new ResponseStructure<UserDto>();
			structure.setMessage("User deleted successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(userDtos);
			return new ResponseEntity<ResponseStructure<UserDto>>(structure, HttpStatus.OK);
		} else {
			throw new UserIdNotFoundException("Failed to update User!!!");
		}
	}

}
