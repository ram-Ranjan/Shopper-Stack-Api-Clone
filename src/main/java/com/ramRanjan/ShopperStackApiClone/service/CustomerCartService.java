package com.ramRanjan.ShopperStackApiClone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ramRanjan.ShopperStackApiClone.dao.CustomerCartDao;
import com.ramRanjan.ShopperStackApiClone.dao.ProductDao;
import com.ramRanjan.ShopperStackApiClone.entity.CustomerCart;
import com.ramRanjan.ShopperStackApiClone.entity.Product;
import com.ramRanjan.ShopperStackApiClone.util.ResponseStructure;

@Service
public class CustomerCartService {

	@Autowired
	private CustomerCartDao cartDao;
	@Autowired
	private ProductDao productDao;
	public ResponseEntity<ResponseStructure<CustomerCart>> addCart(long productId,CustomerCart cart){
		Product product=productDao.getProductById(productId);
		if(product!=null) {
			
		}else {
		return null;
		}
	}
}
