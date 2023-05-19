package com.ramRanjan.ShopperStackApiClone.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ramRanjan.ShopperStackApiClone.dao.ProductDao;
import com.ramRanjan.ShopperStackApiClone.dao.UserDao;
import com.ramRanjan.ShopperStackApiClone.dto.ProductDto;
import com.ramRanjan.ShopperStackApiClone.entity.Product;
import com.ramRanjan.ShopperStackApiClone.entity.User;
import com.ramRanjan.ShopperStackApiClone.exception.ProductNotFoundByIdException;
import com.ramRanjan.ShopperStackApiClone.util.ResponseStructure;

@Service
public class ProductService {

	@Autowired
	ProductDao productDao;
	@Autowired
	UserDao userDao;
	@Autowired
	ModelMapper modelMapper;

	public ResponseEntity<ResponseStructure<ProductDto>> addProduct(long userId, ProductDto productDto) {
		User existingUser = userDao.findUserById(userId);

		if (existingUser != null) {

			Product mappedProduct = modelMapper.map(productDto, Product.class);
			productDao.addProduct(mappedProduct);

			ResponseStructure<ProductDto> structure = new ResponseStructure<ProductDto>();
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(productDto);
			structure.setMessage("Product found with given id");
			return new ResponseEntity<ResponseStructure<ProductDto>>(structure, HttpStatus.FOUND);
		} else
			throw new ProductNotFoundByIdException("Product doesn't exist with given id");
	}

	

	public ResponseEntity<ResponseStructure<ProductDto>> getProductById(long id) {
		Product existingProduct = productDao.getProductById(id);
		if (existingProduct != null) {

			ProductDto productDto = this.modelMapper.map(existingProduct, ProductDto.class);

			ResponseStructure<ProductDto> structure = new ResponseStructure<ProductDto>();
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(productDto);
			structure.setMessage("Product found with given id");
			return new ResponseEntity<ResponseStructure<ProductDto>>(structure, HttpStatus.FOUND);
		} else
			throw new ProductNotFoundByIdException("Product doesn't exist with given id");
	}
	
	public ResponseEntity<ResponseStructure<ProductDto>> updateProduct(long id,ProductDto productDto){
		Product existingProduct = productDao.getProductById(id);
		if (existingProduct != null) {

			Product mappedProduct = this.modelMapper.map(productDto, Product.class);
			productDao.updateProduct(id, mappedProduct);
			
			ResponseStructure<ProductDto> structure = new ResponseStructure<ProductDto>();
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(productDto);
			structure.setMessage("Product found with given id");
			return new ResponseEntity<ResponseStructure<ProductDto>>(structure, HttpStatus.FOUND);
		} else
			throw new ProductNotFoundByIdException("Product doesn't exist with given id");

	}
	public ResponseEntity<ResponseStructure<ProductDto>> deleteProductById(long id){
		 Product existingProduct = productDao.getProductById(id);
			if (existingProduct != null) {
				
				productDao.deleteProduct(id);
				ProductDto productDto  = this.modelMapper.map(existingProduct, ProductDto.class);	
				ResponseStructure<ProductDto> structure = new ResponseStructure<ProductDto>();
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(productDto);
				structure.setMessage("Product found with given id");
				return new ResponseEntity<ResponseStructure<ProductDto>>(structure, HttpStatus.OK);
			} else
				throw new ProductNotFoundByIdException("Product doesn't exist with given id");
		}
		
		
	}
