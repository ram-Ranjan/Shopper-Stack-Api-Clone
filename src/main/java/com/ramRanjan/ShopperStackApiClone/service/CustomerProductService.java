package com.ramRanjan.ShopperStackApiClone.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ramRanjan.ShopperStackApiClone.dao.CategoryDao;
import com.ramRanjan.ShopperStackApiClone.dao.CustomerProductDao;
import com.ramRanjan.ShopperStackApiClone.dao.UserDao;
import com.ramRanjan.ShopperStackApiClone.dto.CustomerProductDto;
import com.ramRanjan.ShopperStackApiClone.dto.ProductDto;
import com.ramRanjan.ShopperStackApiClone.entity.Category;
import com.ramRanjan.ShopperStackApiClone.entity.CustomerProduct;
import com.ramRanjan.ShopperStackApiClone.entity.User;
import com.ramRanjan.ShopperStackApiClone.enums.UserRole;
import com.ramRanjan.ShopperStackApiClone.enums.UserStatus;
import com.ramRanjan.ShopperStackApiClone.exception.CategoryNotFoundByIdException;
import com.ramRanjan.ShopperStackApiClone.exception.ProductNotFoundByIdException;
import com.ramRanjan.ShopperStackApiClone.exception.UserIsNotMerchantException;
import com.ramRanjan.ShopperStackApiClone.exception.UserNotFoundByIdException;
import com.ramRanjan.ShopperStackApiClone.exception.UserStatusBlockedException;
import com.ramRanjan.ShopperStackApiClone.util.ResponseStructure;

@Service
public class CustomerProductService {

	@Autowired
	CustomerProductDao productDao;
	@Autowired
	UserDao userDao;
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	ModelMapper modelMapper;

	public ResponseEntity<ResponseStructure<CustomerProductDto>> addProduct(long userId, long categoryId,
			ProductDto productDto) {
		User existingUser = userDao.findUserById(userId);
		if (existingUser != null) {
			if (existingUser.getUserRole().equals(UserRole.MERCHANT)) {
				if (existingUser.getUserStatus().equals(UserStatus.APPROVED)) {
					Category existingCategory = categoryDao.getCategoryById(categoryId);
					if (existingCategory != null) {
						CustomerProduct mappedProduct = modelMapper.map(productDto, CustomerProduct.class);

						mappedProduct = productDao.addCustomerProduct(mappedProduct);
						productDto.setProductId(mappedProduct.getProductId());

						ResponseStructure<CustomerProductDto> structure = new ResponseStructure<CustomerProductDto>();
						structure.setStatus(HttpStatus.FOUND.value());
						structure.setData(productDto);
						structure.setMessage("Product found with given id");
						return new ResponseEntity<ResponseStructure<CustomerProductDto>>(structure, HttpStatus.FOUND);
					} else
						throw new CategoryNotFoundByIdException("User must be merchant to add product");
				} else
					throw new UserStatusBlockedException("Merchant Status is not Approved to add product");
			} else
				throw new UserIsNotMerchantException("User must be merchant to add product");
		} else
			throw new UserNotFoundByIdException("User doesn't exist with given id");
	}

	public ResponseEntity<ResponseStructure<CustomerProductDto>> getCustomerProductById(long id) {
		CustomerProduct existingProduct = productDao.getCustomerProductById(id);
		if (existingProduct != null) {
			CustomerProductDto productDto = this.modelMapper.map(existingProduct, CustomerProductDto.class);

			ResponseStructure<CustomerProductDto> structure = new ResponseStructure<CustomerProductDto>();
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(productDto);
			structure.setMessage("Product found with given id");
			return new ResponseEntity<ResponseStructure<CustomerProductDto>>(structure, HttpStatus.FOUND);
		} else
			throw new ProductNotFoundByIdException("Product doesn't exist with given id");
	}

	public ResponseEntity<ResponseStructure<CustomerProductDto>> updateCustomerProduct(long userId, long productId,
			ProductDto productDto) {

		User existingUser = userDao.findUserById(userId);
		if (existingUser != null) {
			if (existingUser.getUserRole().equals(UserRole.MERCHANT ) && existingUser.getUserStatus().equals(UserStatus.APPROVED))
{
				CustomerProduct existingProduct = productDao.getCustomerProductById(productId);
				if (existingProduct != null) {

					CustomerProduct mappedProduct = this.modelMapper.map(productDto, CustomerProduct.class);
					//mappedProduct = productDao.updateCustomerProduct(productId, mappedProduct);
					productDto.setProductId(mappedProduct.getProductId());
					ResponseStructure<CustomerProductDto> structure = new ResponseStructure<CustomerProductDto>();
					structure.setStatus(HttpStatus.FOUND.value());
					structure.setData(productDto);
					structure.setMessage("Product found with given id");
					return new ResponseEntity<ResponseStructure<CustomerProductDto>>(structure, HttpStatus.FOUND);
				} else
					throw new ProductNotFoundByIdException("Product doesn't exist with given id");
			} else
				throw new UserIsNotMerchantException("User should be merchant ");
		} else
			throw new UserNotFoundByIdException("User doesn't exist with given id");

	}

	public ResponseEntity<ResponseStructure<CustomerProductDto>> deleteCustomerProductById(long id) {
		CustomerProduct existingProduct = productDao.getCustomerProductById(id);
		if (existingProduct != null) {

//			existingProduct.setProductStatus(ProductStatus.OUTOFSTOCK);
//			existingProduct.setProductStock(0);
//			productDao.updateCustomerProduct(id, existingProduct);
			ProductDto productDto = this.modelMapper.map(existingProduct, ProductDto.class);
			ResponseStructure<CustomerProductDto> structure = new ResponseStructure<CustomerProductDto>();
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(productDto);
			structure.setMessage("Product found with given id");
			return new ResponseEntity<ResponseStructure<CustomerProductDto>>(structure, HttpStatus.OK);
		} else
			throw new ProductNotFoundByIdException("Product doesn't exist with given id");
	}

}
