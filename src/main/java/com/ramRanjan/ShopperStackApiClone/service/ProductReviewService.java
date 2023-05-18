package com.ramRanjan.ShopperStackApiClone.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ramRanjan.ShopperStackApiClone.dao.ProductDao;
import com.ramRanjan.ShopperStackApiClone.dao.ProductReviewDao;
import com.ramRanjan.ShopperStackApiClone.dao.UserDao;
import com.ramRanjan.ShopperStackApiClone.dto.ProductReviewDto;
import com.ramRanjan.ShopperStackApiClone.entity.Product;
import com.ramRanjan.ShopperStackApiClone.entity.ProductReview;
import com.ramRanjan.ShopperStackApiClone.entity.User;
import com.ramRanjan.ShopperStackApiClone.enums.UserRole;
import com.ramRanjan.ShopperStackApiClone.exception.ProductNotFoundByIdException;
import com.ramRanjan.ShopperStackApiClone.exception.UserIsNotCustomerException;
import com.ramRanjan.ShopperStackApiClone.exception.UserNotFoundByIdException;
import com.ramRanjan.ShopperStackApiClone.util.ResponseStructure;

@Service
public class ProductReviewService {

	@Autowired
	ProductReviewDao productReviewDao;
	@Autowired
	UserDao userDao;
	@Autowired
	ProductDao productDao;
	@Autowired
	ModelMapper modelMapper;

	public ResponseEntity<ResponseStructure<ProductReviewDto>> addProductReview(long userId, long productId,
			ProductReviewDto productReviewDto) {
		User existingUser = userDao.findUserById(userId);

		if (existingUser != null) {

			if(existingUser.getUserRole().equals(UserRole.CUSTOMER)) {
			Product existingProduct = productDao.getProductById(productId);
			if (existingProduct != null) {

				ProductReview mappedProductReview = modelMapper.map(productReviewDto, ProductReview.class);
				productReviewDao.addProductReview(mappedProductReview);

				ResponseStructure<ProductReviewDto> structure = new ResponseStructure<ProductReviewDto>();
				structure.setStatus(HttpStatus.FOUND.value());
				structure.setData(productReviewDto);
				structure.setMessage("Product Review found with given id");
				return new ResponseEntity<ResponseStructure<ProductReviewDto>>(structure, HttpStatus.FOUND);
			} else
				throw new ProductNotFoundByIdException("Product Review doesn't exist with given id");
		}
			else
				throw new UserIsNotCustomerException("Only Customer can add reviews");
		
		}else
			throw new UserNotFoundByIdException("Product Review doesn't exist with given id");
	}

	public ResponseEntity<ResponseStructure<ProductReviewDto>> getProductReviewById(long id) {
		ProductReview existingProductReview = productReviewDao.getProductReviewById(id);
		if (existingProductReview != null) {

			ProductReviewDto productReviewDto = this.modelMapper.map(existingProductReview, ProductReviewDto.class);

			ResponseStructure<ProductReviewDto> structure = new ResponseStructure<ProductReviewDto>();
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(productReviewDto);
			structure.setMessage("Product Review found with given id");
			return new ResponseEntity<ResponseStructure<ProductReviewDto>>(structure, HttpStatus.FOUND);
		} else
			throw new ProductNotFoundByIdException("Product  Review doesn't exist with given id");
	}

	public ResponseEntity<ResponseStructure<ProductReviewDto>> updateProductReview(long id,
			ProductReviewDto productReviewDto) {
		ProductReview existingProductReview = productReviewDao.getProductReviewById(id);
		if (existingProductReview != null) {

			ProductReview mappedProductReview = this.modelMapper.map(productReviewDto, ProductReview.class);
			productReviewDao.updateProductReview(id, mappedProductReview);

			ResponseStructure<ProductReviewDto> structure = new ResponseStructure<ProductReviewDto>();
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(productReviewDto);
			structure.setMessage("Product Review found with given id");
			return new ResponseEntity<ResponseStructure<ProductReviewDto>>(structure, HttpStatus.FOUND);
		} else
			throw new ProductNotFoundByIdException("Product Review doesn't exist with given id");

	}

	public ResponseEntity<ResponseStructure<ProductReviewDto>> deleteProductReview(long id) {
		ProductReview existingProductReview = productReviewDao.getProductReviewById(id);
		if (existingProductReview != null) {

			productReviewDao.deleteProductReview(id);
			ProductReviewDto productReviewDto = this.modelMapper.map(existingProductReview, ProductReviewDto.class);
			ResponseStructure<ProductReviewDto> structure = new ResponseStructure<ProductReviewDto>();
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(productReviewDto);
			structure.setMessage("Product Review found with given id");
			return new ResponseEntity<ResponseStructure<ProductReviewDto>>(structure, HttpStatus.OK);
		} else
			throw new ProductNotFoundByIdException("Product Review doesn't exist with given id");

	}

}
