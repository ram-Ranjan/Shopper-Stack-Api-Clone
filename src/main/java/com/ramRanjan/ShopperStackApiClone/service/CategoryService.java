package com.ramRanjan.ShopperStackApiClone.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ramRanjan.ShopperStackApiClone.dao.CategoryDao;
import com.ramRanjan.ShopperStackApiClone.dao.UserDao;
import com.ramRanjan.ShopperStackApiClone.dto.CategoryDto;
import com.ramRanjan.ShopperStackApiClone.entity.Category;
import com.ramRanjan.ShopperStackApiClone.entity.Product;
import com.ramRanjan.ShopperStackApiClone.entity.User;
import com.ramRanjan.ShopperStackApiClone.enums.UserRole;
import com.ramRanjan.ShopperStackApiClone.enums.UserStatus;
import com.ramRanjan.ShopperStackApiClone.exception.CategoryCanNotBeDeletedException;
import com.ramRanjan.ShopperStackApiClone.exception.CategoryNotFoundByIdException;
import com.ramRanjan.ShopperStackApiClone.exception.UserIsNotMerchantException;
import com.ramRanjan.ShopperStackApiClone.exception.UserNotFoundByIdException;
import com.ramRanjan.ShopperStackApiClone.util.ResponseStructure;

@Service
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private ModelMapper modelMapper;

	public ResponseEntity<ResponseStructure<CategoryDto>> addCategory(long userId,
			Category category) {
		User user = userDao.findUserById(userId);
		if (user != null) {
			if (user.getUserRole().equals(UserRole.MERCHANT) && user.getUserStatus().equals(UserStatus.APPROVED)) {
				categoryDao.addCategory(category);
				ResponseStructure<CategoryDto> responseStructure = new ResponseStructure<>();
				responseStructure.setStatus(HttpStatus.CREATED.value());
				responseStructure.setMessage("Category added");
				CategoryDto categoryDto = modelMapper.map(category, CategoryDto.class);
				responseStructure.setData(categoryDto);
				return new ResponseEntity<ResponseStructure<CategoryDto>>(responseStructure, HttpStatus.CREATED);
			} else {
				throw new UserIsNotMerchantException("Only merchant with status approved can add Category");
			}
		} else {
			throw new UserNotFoundByIdException("User not found");
		}

	}

	public ResponseEntity<ResponseStructure<CategoryDto>> updateCategory(long categoryId,
			Category category) {
		
		Category existingCategory = categoryDao.getCategoryById(categoryId);
		if (existingCategory!=null) {
			
			category.setCategoryId(existingCategory.getCategoryId());
			category.setProducts(existingCategory.getProducts());
			categoryDao.updateCategory(categoryId, existingCategory);
			
			ResponseStructure<CategoryDto> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("Category updated");
			CategoryDto categoryDto = modelMapper.map(category, CategoryDto.class);
			responseStructure.setData(categoryDto);
			return new ResponseEntity<ResponseStructure<CategoryDto>>(responseStructure, HttpStatus.CREATED);
		} else {
			throw new CategoryNotFoundByIdException("Failed to update Category.");
		}
	}

	public ResponseEntity<ResponseStructure<CategoryDto>> deleteCategory(long categoryId) {
		Category existingCategory = categoryDao.getCategoryById(categoryId);
		if (existingCategory !=null) {
			List<Product> products = existingCategory.getProducts();
			if (products != null && products.size() > 0) {
				throw new CategoryCanNotBeDeletedException("Failed to delete Category.");
			} else {
				categoryDao.deleteCategory(categoryId);
				ResponseStructure<CategoryDto> responseStructure = new ResponseStructure<>();
				responseStructure.setStatus(HttpStatus.OK.value());
				responseStructure.setMessage("Category deleted");
				CategoryDto categoryDto = modelMapper.map(existingCategory, CategoryDto.class);
				responseStructure.setData(categoryDto);
				return new ResponseEntity<ResponseStructure<CategoryDto>>(responseStructure, HttpStatus.OK);
			}
		} else {
			throw new CategoryNotFoundByIdException("Failed to delete Category.");
		}
	}

}