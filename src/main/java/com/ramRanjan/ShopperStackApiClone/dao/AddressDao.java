package com.ramRanjan.ShopperStackApiClone.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ramRanjan.ShopperStackApiClone.entity.Address;
import com.ramRanjan.ShopperStackApiClone.repository.AddressRepo;

@Repository
public class AddressDao {

	@Autowired
	private AddressRepo repo;
	
	public Address saveAddress(Address address) {
		return repo.save(address);
	}
	public Address updateAddress(long addressId,Address address) {
		if(repo.findById(addressId).isPresent()) {
			address.setAddressiD(addressId);
			return repo.save(address);
		}
		return null;
	}
	public Address findAddressById(long addressId) {
		if(repo.findById(addressId).isPresent()) {
			return repo.findById(addressId).get();
		}return null;
	}
	public Address deleteAddress(long addressId) {
		if(repo.findById(addressId).isPresent()) {
			Address address=repo.findById(addressId).get();
			repo.delete(address);
			return address;
		}
		return null;
	}
}
