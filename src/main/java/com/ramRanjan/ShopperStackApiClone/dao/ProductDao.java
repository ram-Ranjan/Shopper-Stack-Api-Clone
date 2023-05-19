package com.ramRanjan.ShopperStackApiClone.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ramRanjan.ShopperStackApiClone.entity.Product;
import com.ramRanjan.ShopperStackApiClone.repository.ProductRepo;

@Repository
public class ProductDao {

	@Autowired
	ProductRepo productRepo;

	public Product addProduct(Product product) {
		return productRepo.save(product);
	}

	public Product getProductById(long id) {
		Optional<Product> optional = productRepo.findById(id);
		if (optional.isPresent())
			return optional.get();
		else
			return null;

	}

	public Product updateProduct(long id, Product product) {
		Optional<Product> optional = productRepo.findById(id);
		if (optional.isPresent()) {
			product.setProductId(id);
			product = productRepo.save(product);
			return product;
		} else
			return null;
	}

	public Product deleteProduct(long id) {
		Optional<Product> optional = productRepo.findById(id);
		if (optional.isPresent()) {
			productRepo.deleteById(id);
			return optional.get();
		} else
			return null;
	}

}
