package com.ramRanjan.ShopperStackApiClone.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ramRanjan.ShopperStackApiClone.dao.ProductDao;
import com.ramRanjan.ShopperStackApiClone.dao.UserDao;
import com.ramRanjan.ShopperStackApiClone.dao.WishlistDao;
import com.ramRanjan.ShopperStackApiClone.dto.WishlistDto;
import com.ramRanjan.ShopperStackApiClone.entity.Product;
import com.ramRanjan.ShopperStackApiClone.entity.User;
import com.ramRanjan.ShopperStackApiClone.entity.Wishlist;
import com.ramRanjan.ShopperStackApiClone.enums.UserRole;
import com.ramRanjan.ShopperStackApiClone.exception.ProductNotFoundByIdException;
import com.ramRanjan.ShopperStackApiClone.exception.UserIsNotCustomerException;
import com.ramRanjan.ShopperStackApiClone.exception.UserNotFoundByIdException;
import com.ramRanjan.ShopperStackApiClone.exception.WishlistNotFoundByIdException;
import com.ramRanjan.ShopperStackApiClone.util.ResponseStructure;

@Service
public class WishlistService {

	@Autowired
	WishlistDao wishlistDao;
	@Autowired
	UserDao userDao;
	@Autowired
	ProductDao productDao;
	@Autowired
	ModelMapper modelMapper;

	public ResponseEntity<ResponseStructure<WishlistDto>> addWishlist(long userId, long productId,
			WishlistDto wishlistDto) {
		User existingUser = userDao.findUserById(userId);

		if (existingUser != null) {

			if(existingUser.getUserRole().equals(UserRole.CUSTOMER)) {
			Product existingProduct = productDao.getProductById(productId);
			if (existingProduct != null) {

				Wishlist mappedWishlist = modelMapper.map(wishlistDto, Wishlist.class);
				wishlistDao.addWishlist(mappedWishlist);

				ResponseStructure<WishlistDto> structure = new ResponseStructure<WishlistDto>();
				structure.setStatus(HttpStatus.FOUND.value());
				structure.setData(wishlistDto);
				structure.setMessage("Product Review found with given id");
				return new ResponseEntity<ResponseStructure<WishlistDto>>(structure, HttpStatus.FOUND);
			} else
				throw new ProductNotFoundByIdException("Product Review doesn't exist with given id");
		}
			else
				throw new UserIsNotCustomerException("Only Customer can add Wishlist");
		
		}else
			throw new UserNotFoundByIdException("User doesn't exist with given id");
	}

	

	public ResponseEntity<ResponseStructure<WishlistDto>> getWishlistById(long id) {
		Wishlist existingWishlist = wishlistDao.getWishlistById(id);
		if (existingWishlist != null) {

			WishlistDto wishlistDto = this.modelMapper.map(existingWishlist, WishlistDto.class);

			ResponseStructure<WishlistDto> structure = new ResponseStructure<WishlistDto>();
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(wishlistDto);
			structure.setMessage("Wishlist found with given id");
			return new ResponseEntity<ResponseStructure<WishlistDto>>(structure, HttpStatus.FOUND);
		} else
			throw new WishlistNotFoundByIdException("Wishlist doesn't exist with given id");
	}
	
	public ResponseEntity<ResponseStructure<WishlistDto>> updateWishlist(long id,WishlistDto wishlistDto){
		Wishlist existingWishlist = wishlistDao.getWishlistById(id);
		if (existingWishlist != null) {

			Wishlist mappedWishlist = this.modelMapper.map(wishlistDto, Wishlist.class);
			wishlistDao.updateWishlist(id, mappedWishlist);
			
			ResponseStructure<WishlistDto> structure = new ResponseStructure<WishlistDto>();
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(wishlistDto);
			structure.setMessage("Wishlist found with given id");
			return new ResponseEntity<ResponseStructure<WishlistDto>>(structure, HttpStatus.FOUND);
		} else
			throw new ProductNotFoundByIdException("Wishlist doesn't exist with given id");

	}
	public ResponseEntity<ResponseStructure<WishlistDto>> deleteWishlistById(long id){
		Wishlist existingWishlist = wishlistDao.getWishlistById(id);
			if (existingWishlist != null) {
				
				wishlistDao.deleteProduct(id);
				WishlistDto wishlistDto  = this.modelMapper.map(existingWishlist, WishlistDto.class);	
				ResponseStructure<WishlistDto> structure = new ResponseStructure<WishlistDto>();
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(wishlistDto);
				structure.setMessage("Wishlist found with given id");
				return new ResponseEntity<ResponseStructure<WishlistDto>>(structure, HttpStatus.OK);
			} else
				throw new ProductNotFoundByIdException("Wishlist doesn't exist with given id");

		}
		
		
	}
