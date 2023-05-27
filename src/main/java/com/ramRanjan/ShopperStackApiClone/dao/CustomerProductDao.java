package com.ramRanjan.ShopperStackApiClone.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ramRanjan.ShopperStackApiClone.entity.CustomerProduct;
import com.ramRanjan.ShopperStackApiClone.entity.Product;
import com.ramRanjan.ShopperStackApiClone.repository.CustomerProductRepo;

@Repository
public class CustomerProductDao {

	@Autowired
	CustomerProductRepo productRepo;

	public CustomerProduct addCustomerProduct(CustomerProduct product) {
		return productRepo.save(product);
	}

	public CustomerProduct getCustomerProductById(long id) {
		Optional<CustomerProduct> optional = productRepo.findById(id);
		if (optional.isPresent())
			return optional.get();
		else
			return null;

	}

	public CustomerProduct updateProduct(long id, CustomerProduct product) {
		Optional<CustomerProduct> optional = productRepo.findById(id);
		if (optional.isPresent()) {
			product.setProductId(id);
			product = productRepo.save(product);
			return product;
		} else
			return null;
	}

	public CustomerProduct deleteCustomerProduct(long id) {
		Optional<CustomerProduct> optional = productRepo.findById(id);
		if (optional.isPresent()) {
			productRepo.deleteById(id);
			return optional.get();
		} else
			return null;
	}

}
