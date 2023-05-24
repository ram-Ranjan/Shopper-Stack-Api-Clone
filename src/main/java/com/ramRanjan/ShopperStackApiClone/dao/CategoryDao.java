package com.ramRanjan.ShopperStackApiClone.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ramRanjan.ShopperStackApiClone.entity.Category;
import com.ramRanjan.ShopperStackApiClone.entity.Product;
import com.ramRanjan.ShopperStackApiClone.repository.CategoryRepo;

@Repository
public class CategoryDao {

	@Autowired
	CategoryRepo categoryRepo;

	public Category addCategory(Category category) {
		return categoryRepo.save(category);
	}

	public Category getCategoryById(long id) {
		Optional<Category> optional = categoryRepo.findById(id);
		if (optional.isPresent())
			return optional.get();
		else
			return null;

	}

	public Category updateCategory(long id, Category category) {
		Optional<Category> optional = categoryRepo.findById(id);
		if (optional.isPresent()) {
			category.setCategoryId(id);
			category = categoryRepo.save(category);
			return category;
		} else
			return null;
	}

	public Category deleteCategory(long id) {
		Optional<Category> optional = categoryRepo.findById(id);
		if (optional.isPresent()) {
			categoryRepo.deleteById(id);
			return optional.get();
		} else
			return null;
	}

}
