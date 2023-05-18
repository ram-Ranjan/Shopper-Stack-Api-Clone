package com.ramRanjan.ShopperStackApiClone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ramRanjan.ShopperStackApiClone.dao.AddressDao;
import com.ramRanjan.ShopperStackApiClone.entity.Address;
import com.ramRanjan.ShopperStackApiClone.util.ResponseStructure;

@Service
public class AddressService {
	@Autowired
	private AddressDao dao;
	public ResponseEntity<ResponseStructure<Address>> saveAddress(int userId,Address address){
		
	}

}
