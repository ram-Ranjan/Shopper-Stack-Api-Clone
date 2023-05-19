package com.ramRanjan.ShopperStackApiClone.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ramRanjan.ShopperStackApiClone.dao.CustomerCartDao;
import com.ramRanjan.ShopperStackApiClone.dao.ProductDao;
import com.ramRanjan.ShopperStackApiClone.dto.CustomerCartDto;
import com.ramRanjan.ShopperStackApiClone.entity.CustomerCart;
import com.ramRanjan.ShopperStackApiClone.entity.Product;
import com.ramRanjan.ShopperStackApiClone.exception.CartIdNotFoundException;
import com.ramRanjan.ShopperStackApiClone.exception.ProductNotFoundByIdException;
import com.ramRanjan.ShopperStackApiClone.util.ResponseStructure;

@Service
public class CustomerCartService {

	@Autowired
	private CustomerCartDao cartDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private ModelMapper modelMapper;
	public ResponseEntity<ResponseStructure<CustomerCart>> addCart(long productId,CustomerCartDto cartDto){
		Product product=productDao.getProductById(productId);
		if(product!=null) {
			CustomerCart cart=this.modelMapper.map(cartDto, CustomerCart.class);
			List<Product> products=new ArrayList<Product>();
			products.add(product);
			cart.setProducts(products);
			CustomerCart dbCart=cartDao.saveCustomerCart(cart);
			if(dbCart!=null) {
				ResponseStructure<CustomerCart> structure=new ResponseStructure<CustomerCart>();
				structure.setMessage("Product to the cart added successfully");
				structure.setStatus(HttpStatus.CREATED.value());
				structure.setData(dbCart);
				return new ResponseEntity<ResponseStructure<CustomerCart>>(structure,HttpStatus.CREATED);
			}
			return null;
		}else {
	throw  new ProductNotFoundByIdException("Failed to add product to Cart");
//		product id not found  exception
		}
	}
	public ResponseEntity<ResponseStructure<CustomerCart>> updateCart(long cartId,CustomerCartDto cartDto){
		CustomerCart cart=this.modelMapper.map(cartDto, CustomerCart.class);
		CustomerCart dbCart=cartDao.updateCustomerCart(cartId, cart) ;
		if(dbCart!=null) {
			ResponseStructure<CustomerCart> structure=new ResponseStructure<CustomerCart>();
			structure.setMessage("Cart updated successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dbCart);
			return new ResponseEntity<ResponseStructure<CustomerCart>>(structure,HttpStatus.OK);
		}else {
			throw new CartIdNotFoundException("Failed to update Cart");
		}
	} 
	public ResponseEntity<ResponseStructure<CustomerCart>> findCart(long cartId){
		CustomerCart dbCart=cartDao.findCart(cartId);
		if(dbCart!=null) {
			ResponseStructure<CustomerCart> structure=new ResponseStructure<CustomerCart>();
			structure.setMessage("Cart Fetched successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dbCart);
			return new ResponseEntity<ResponseStructure<CustomerCart>>(structure,HttpStatus.FOUND);
		}else {
			throw new CartIdNotFoundException("Failed to fetch Cart");
		}
		}
	public ResponseEntity<ResponseStructure<CustomerCart>> deleteCart(long cartId){
		CustomerCart dbCart=cartDao.deleteCart(cartId);
		if(dbCart!=null) {
			ResponseStructure<CustomerCart> structure=new ResponseStructure<CustomerCart>();
			structure.setMessage("Cart Deleted successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dbCart);
			return new ResponseEntity<ResponseStructure<CustomerCart>>(structure,HttpStatus.OK);
		}else {
			throw new CartIdNotFoundException("Failed to delete Cart");
		}
		}
}
