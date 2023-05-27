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
import com.ramRanjan.ShopperStackApiClone.dao.UserDao;
import com.ramRanjan.ShopperStackApiClone.dto.CustomerCartDto;
import com.ramRanjan.ShopperStackApiClone.entity.CustomerCart;
import com.ramRanjan.ShopperStackApiClone.entity.CustomerProduct;
import com.ramRanjan.ShopperStackApiClone.entity.Product;
import com.ramRanjan.ShopperStackApiClone.entity.User;
import com.ramRanjan.ShopperStackApiClone.enums.ProductStatus;
import com.ramRanjan.ShopperStackApiClone.enums.UserRole;
import com.ramRanjan.ShopperStackApiClone.exception.CartIdNotFoundException;
import com.ramRanjan.ShopperStackApiClone.exception.ProductNotFoundByIdException;
import com.ramRanjan.ShopperStackApiClone.exception.UserNotFoundByIdException;
import com.ramRanjan.ShopperStackApiClone.util.ResponseStructure;

@Service
public class CustomerCartService {

	@Autowired
	private CustomerCartDao cartDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private CustomerCartDto cart;
	@Autowired
	private ModelMapper modelMapper;

	public ResponseEntity<ResponseStructure<CustomerCart>> addCart(long userId ,long productId){
		
		User existingUser = userDao.findUserById(userId);
		if(existingUser!=null && existingUser.getUserRole().equals(UserRole.CUSTOMER))
		{
		Product product=productDao.getProductById(productId);
		if(product!=null) {
			
		CustomerCart cart = existingUser.getCart();
		List<CustomerProduct> products = cart.getCustomerProducts();
			if(products.contains(product)) {
				products.remove(product);
				product.setProductQuantity(product.getProductQuantity()+1);
				
			}
//			List<Product> productList=cart.getProducts();
//			if(productList.contains(product))
//			{
//				product.setProductQuantity(product.getProductQuantity()+1);
//				productDao.updateProduct(productId, product);
//				cartDao.saveCustomerCart(cart);
//			}
//			else {
//			
//			productList.add(product);
//			cart.setProducts(productList);
//			
//			cart.setCustomerCartDiscount(product.getProductDiscount());
//			cart.setCustomerCartSubTotal(product.getProductQuantity()*product.getDiscountedPrice());
//			
//			if(product.getProductStock()- product.getProductQuantity() > 0) {
//				product.setProductStock(product.getProductStock()-product.getProductQuantity());
//			}
//			else {
//				product.setProductStock(0);
//				product.setProductStatus(ProductStatus.OUTOFSTOCK);
//			}
//			}
//			productDao.updateProduct(productId, product);
			
			CustomerCart dbCart=cartDao.saveCustomerCart(cart);
				ResponseStructure<CustomerCart> structure=new ResponseStructure<CustomerCart>();
				structure.setMessage("Product to the cart added successfully");
				structure.setStatus(HttpStatus.CREATED.value());
				structure.setData(dbCart);
				return new ResponseEntity<ResponseStructure<CustomerCart>>(structure,HttpStatus.CREATED);
						}
			else 
			throw  new ProductNotFoundByIdException("Failed to add product to Cart");
		}
		else
			throw  new UserNotFoundByIdException("Failed to Find Customer");
		
	}

	public ResponseEntity<ResponseStructure<CustomerCart>> updateCart(long cartId, CustomerCartDto cartDto) {
		CustomerCart cart = this.modelMapper.map(cartDto, CustomerCart.class);
		CustomerCart dbCart = cartDao.updateCustomerCart(cartId, cart);
		if (dbCart != null) {
			ResponseStructure<CustomerCart> structure = new ResponseStructure<CustomerCart>();
			structure.setMessage("Cart updated successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dbCart);
			return new ResponseEntity<ResponseStructure<CustomerCart>>(structure, HttpStatus.OK);
		} else {
			throw new CartIdNotFoundException("Failed to update Cart");
		}
	}

	public ResponseEntity<ResponseStructure<CustomerCart>> findCart(long cartId) {
		CustomerCart dbCart = cartDao.findCart(cartId);
		if (dbCart != null) {
			ResponseStructure<CustomerCart> structure = new ResponseStructure<CustomerCart>();
			structure.setMessage("Cart Fetched successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dbCart);
			return new ResponseEntity<ResponseStructure<CustomerCart>>(structure, HttpStatus.FOUND);
		} else {
			throw new CartIdNotFoundException("Failed to fetch Cart");
		}
	}

	public ResponseEntity<ResponseStructure<CustomerCart>> deleteCart(long cartId) {
		CustomerCart dbCart = cartDao.deleteCart(cartId);
		if (dbCart != null) {
			ResponseStructure<CustomerCart> structure = new ResponseStructure<CustomerCart>();
			structure.setMessage("Cart Deleted successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dbCart);
			return new ResponseEntity<ResponseStructure<CustomerCart>>(structure, HttpStatus.OK);
		} else {
			throw new CartIdNotFoundException("Failed to delete Cart");
		}
	}
}
