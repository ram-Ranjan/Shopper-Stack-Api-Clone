package com.ramRanjan.ShopperStackApiClone.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ramRanjan.ShopperStackApiClone.entity.CustomerOrder;
import com.ramRanjan.ShopperStackApiClone.repository.CustomerOrderRepo;

@Repository
public class CustomerOrderDao {
	@Autowired
	private CustomerOrderRepo orderRepo;

	public CustomerOrder saveCustomerOrder(CustomerOrder order) {
		return orderRepo.save(order);
	}

	public CustomerOrder updateCustomerOrder(long orderId, CustomerOrder order) {
		if (orderRepo.findById(orderId).isPresent()) {
			order.setCustomerOrderId(orderId);
			return orderRepo.save(order);
		}
		return null;
	}

	public CustomerOrder getCustomerOrderById(long orderId) {
		if (orderRepo.findById(orderId).isPresent()) {
			return orderRepo.findById(orderId).get();
		}
		return null;
	}

	public CustomerOrder deleteCustomerOrder(long orderId) {
		if (orderRepo.findById(orderId).isPresent()) {
			CustomerOrder order = orderRepo.findById(orderId).get();
			orderRepo.delete(order);
			return order;
		}
		return null;
	}
}
