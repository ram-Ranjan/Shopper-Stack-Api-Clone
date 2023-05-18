package com.ramRanjan.ShopperStackApiClone.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ramRanjan.ShopperStackApiClone.dao.UserDao;
import com.ramRanjan.ShopperStackApiClone.dto.UserDto;
import com.ramRanjan.ShopperStackApiClone.entity.User;
import com.ramRanjan.ShopperStackApiClone.util.ResponseStructure;

@Service
public class UserService {
	@Autowired
	private ModelMapper modelMapper;
@Autowired
private UserDao userDao;
public ResponseEntity<ResponseStructure<UserDto>> addUser(User user){
	
	User  user2=userDao.saveUser(user);
	if(user2!=null) {
		UserDto userDto=this.modelMapper.map(user2, UserDto.class);
		ResponseStructure<UserDto> structure=new ResponseStructure<UserDto>();
		structure.setMessage("User added successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(userDto);
		return new ResponseEntity<ResponseStructure<UserDto>>(structure,HttpStatus.CREATED);
	}
	return null;
}
public ResponseEntity<ResponseStructure<UserDto>> updateUser(long userId,User user){
	User dbUser=userDao.updateAddress(userId, user) ;
	if(dbUser!=null) {
		UserDto userDto=this.modelMapper.map(dbUser, UserDto.class);
		ResponseStructure<UserDto> structure=new ResponseStructure<UserDto>();
		structure.setMessage("User updqated successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(userDto);
		return new ResponseEntity<ResponseStructure<UserDto>>(structure,HttpStatus.OK);
	}else {
//		id not found exception
		return null;
	}
	}
}
