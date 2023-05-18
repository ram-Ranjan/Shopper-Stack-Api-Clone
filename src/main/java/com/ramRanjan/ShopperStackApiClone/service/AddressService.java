package com.ramRanjan.ShopperStackApiClone.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ramRanjan.ShopperStackApiClone.dao.AddressDao;
import com.ramRanjan.ShopperStackApiClone.dao.UserDao;
import com.ramRanjan.ShopperStackApiClone.dto.AddressDto;
import com.ramRanjan.ShopperStackApiClone.entity.Address;
import com.ramRanjan.ShopperStackApiClone.entity.User;
import com.ramRanjan.ShopperStackApiClone.util.ResponseStructure;

@Service
public class AddressService {
	@Autowired
	private AddressDao addressDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private ModelMapper modelMapper;
	
	public ResponseEntity<ResponseStructure<Address>> saveAddress(long userId,AddressDto addressDto){
		User user=userDao.findUserById(userId);
		if(user!=null) {
			Address address=this.modelMapper.map(addressDto, Address.class);
			address.setUser(user);
			Address dbAddress=addressDao.saveAddress(address);
			if(dbAddress!=null) {
				ResponseStructure<Address> structure=new ResponseStructure<Address>();
				structure.setMessage("address saved successfully");
				structure.setStatus(HttpStatus.CREATED.value());
				structure.setData(dbAddress);
				return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.CREATED);
			}
			return  null;
			
		}else {
			return null;
//			userIdNoTFound
		}
	}
	
	public ResponseEntity<ResponseStructure<Address>> updateAddress(long addressId,AddressDto addressDto){
		Address modeluser=this.modelMapper.map(addressDto, Address.class);
		Address dbAddress=addressDao.updateAddress(addressId, modeluser);
		if(dbAddress!=null) {
			ResponseStructure<Address> structure=new ResponseStructure<Address>();
			structure.setMessage("address updated successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dbAddress);
			return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.OK);
		}else {
			return null;
//			addressIdnot
		}
	}
public ResponseEntity<ResponseStructure<Address>> findAddress(long addressId){
	Address address=addressDao.findAddressById(addressId);
	if(address!=null) {

		ResponseStructure<Address> structure=new ResponseStructure<Address>();
		structure.setMessage("address fetched successfully");
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setData(address);
		return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.FOUND);
	
	}else {
		return null;
//		addressIdNot
	}
}
public ResponseEntity<ResponseStructure<Address>> deleteAddress(long addressId){
	Address address=addressDao.deleteAddress(addressId);
	if(address!=null) {

		ResponseStructure<Address> structure=new ResponseStructure<Address>();
		structure.setMessage("address deleted successfully");
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setData(address);
		return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.FOUND);
	
	}else {
		return null;
//		addressIdNot
	}
}

}
