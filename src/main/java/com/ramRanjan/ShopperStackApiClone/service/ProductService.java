package com.ramRanjan.ShopperStackApiClone.service;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ramRanjan.ShopperStackApiClone.dao.CategoryDao;
import com.ramRanjan.ShopperStackApiClone.dao.ProductDao;
import com.ramRanjan.ShopperStackApiClone.dao.UserDao;
import com.ramRanjan.ShopperStackApiClone.dto.ProductDto;
import com.ramRanjan.ShopperStackApiClone.entity.Category;
import com.ramRanjan.ShopperStackApiClone.entity.Product;
import com.ramRanjan.ShopperStackApiClone.entity.User;
import com.ramRanjan.ShopperStackApiClone.enums.ProductStatus;
import com.ramRanjan.ShopperStackApiClone.enums.UserRole;
import com.ramRanjan.ShopperStackApiClone.enums.UserStatus;
import com.ramRanjan.ShopperStackApiClone.exception.CategoryNotFoundByIdException;
import com.ramRanjan.ShopperStackApiClone.exception.ProductNotFoundByIdException;
import com.ramRanjan.ShopperStackApiClone.exception.UserIsNotMerchantException;
import com.ramRanjan.ShopperStackApiClone.exception.UserNotFoundByIdException;
import com.ramRanjan.ShopperStackApiClone.exception.UserStatusBlockedException;
import com.ramRanjan.ShopperStackApiClone.util.ResponseStructure;

@Service
public class ProductService {

	@Autowired
	ProductDao productDao;
	@Autowired
	UserDao userDao;
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	ModelMapper modelMapper;

	public ResponseEntity<ResponseStructure<ProductDto>> addProduct(long userId, long categoryId,
			ProductDto productDto) {
		User existingUser = userDao.findUserById(userId);
		if (existingUser != null) {
			if (existingUser.getUserRole().equals(UserRole.MERCHANT)) {
				if (existingUser.getUserStatus().equals(UserStatus.APPROVED)) {
					Category existingCategory = categoryDao.getCategoryById(categoryId);
					if (existingCategory != null) {
						Product mappedProduct = modelMapper.map(productDto, Product.class);

						mappedProduct.setAddedDate(LocalDate.now());
						mappedProduct = productDao.addProduct(mappedProduct);
						productDto.setProductId(mappedProduct.getProductId());

						productDto.setAddedDate(mappedProduct.getAddedDate());
						ResponseStructure<ProductDto> structure = new ResponseStructure<ProductDto>();
						structure.setStatus(HttpStatus.FOUND.value());
						structure.setData(productDto);
						structure.setMessage("Product found with given id");
						return new ResponseEntity<ResponseStructure<ProductDto>>(structure, HttpStatus.FOUND);
					} else
						throw new CategoryNotFoundByIdException("User must be merchant to add product");
				} else
					throw new UserStatusBlockedException("Merchant Status is not Approved to add product");
			} else
				throw new UserIsNotMerchantException("User must be merchant to add product");
		} else
			throw new UserNotFoundByIdException("User doesn't exist with given id");
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

	public ResponseEntity<ResponseStructure<ProductDto>> updateProduct(long userId, long productId,
			ProductDto productDto) {

		User existingUser = userDao.findUserById(userId);
		if (existingUser != null) {
			if (existingUser.getUserRole().equals(UserRole.MERCHANT ) && existingUser.getUserStatus().equals(UserStatus.APPROVED))
{
				Product existingProduct = productDao.getProductById(productId);
				if (existingProduct != null) {

					Product mappedProduct = this.modelMapper.map(productDto, Product.class);
					mappedProduct = productDao.updateProduct(productId, mappedProduct);
					productDto.setProductId(mappedProduct.getProductId());
					ResponseStructure<ProductDto> structure = new ResponseStructure<ProductDto>();
					structure.setStatus(HttpStatus.FOUND.value());
					structure.setData(productDto);
					structure.setMessage("Product found with given id");
					return new ResponseEntity<ResponseStructure<ProductDto>>(structure, HttpStatus.FOUND);
				} else
					throw new ProductNotFoundByIdException("Product doesn't exist with given id");
			} else
				throw new UserIsNotMerchantException("User should be merchant ");
		} else
			throw new UserNotFoundByIdException("User doesn't exist with given id");

	}

	public ResponseEntity<ResponseStructure<ProductDto>> deleteProductById(long id) {
		Product existingProduct = productDao.getProductById(id);
		if (existingProduct != null) {

			existingProduct.setProductStatus(ProductStatus.OUTOFSTOCK);
			existingProduct.setProductStock(0);
			productDao.updateProduct(id, existingProduct);
			ProductDto productDto = this.modelMapper.map(existingProduct, ProductDto.class);
			ResponseStructure<ProductDto> structure = new ResponseStructure<ProductDto>();
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(productDto);
			structure.setMessage("Product found with given id");
			return new ResponseEntity<ResponseStructure<ProductDto>>(structure, HttpStatus.OK);
		} else
			throw new ProductNotFoundByIdException("Product doesn't exist with given id");
	}

}
