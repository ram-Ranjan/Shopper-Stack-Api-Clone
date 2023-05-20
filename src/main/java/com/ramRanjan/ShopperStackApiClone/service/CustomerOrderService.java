package com.ramRanjan.ShopperStackApiClone.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ramRanjan.ShopperStackApiClone.dao.CustomerCartDao;
import com.ramRanjan.ShopperStackApiClone.dao.CustomerOrderDao;
import com.ramRanjan.ShopperStackApiClone.dto.CustomerOrderDto;
import com.ramRanjan.ShopperStackApiClone.entity.CustomerCart;
import com.ramRanjan.ShopperStackApiClone.entity.CustomerOrder;
import com.ramRanjan.ShopperStackApiClone.exception.CartIdNotFoundException;
import com.ramRanjan.ShopperStackApiClone.exception.OrderIdNotFoundException;
import com.ramRanjan.ShopperStackApiClone.util.ResponseStructure;

@Service
public class CustomerOrderService {
	@Autowired
	private CustomerOrderDao orderDao;
	@Autowired
	private CustomerCartDao cartDao;
	@Autowired
	private ModelMapper modelMapper;

	public ResponseEntity<ResponseStructure<CustomerOrder>> addOrder(long cartId, CustomerOrderDto customerDto) {
		CustomerCart cart = cartDao.findCart(cartId);
		if (cart != null) {
			CustomerOrder order = this.modelMapper.map(customerDto, CustomerOrder.class);
			order.setCart(cart);
			CustomerOrder dbCartOrder = orderDao.saveCustomerOrder(order);
			if (dbCartOrder != null) {
				ResponseStructure<CustomerOrder> structure = new ResponseStructure<CustomerOrder>();
				structure.setMessage("Ordered  successfully");
				structure.setStatus(HttpStatus.CREATED.value());
				structure.setData(dbCartOrder);
				return new ResponseEntity<ResponseStructure<CustomerOrder>>(structure, HttpStatus.CREATED);
			}
			return null;
		} else {
		throw new CartIdNotFoundException("failed to order!");

		}
	}

	public ResponseEntity<ResponseStructure<CustomerOrder>> updateOrder(long orderId, CustomerOrderDto orderDto) {
		CustomerOrder order = this.modelMapper.map(orderDto, CustomerOrder.class);
		CustomerOrder dbOrder =orderDao.updateCustomerOrder(orderId, order);
		if (dbOrder != null) {
			ResponseStructure<CustomerOrder> structure = new ResponseStructure<CustomerOrder>();
			structure.setMessage("Order updated successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dbOrder);
			return new ResponseEntity<ResponseStructure<CustomerOrder>>(structure, HttpStatus.OK);
		} else {
			throw new OrderIdNotFoundException("Failed to update Order");
		}
	}

	public ResponseEntity<ResponseStructure<CustomerOrder>> getOrderById(long orderId) {
		CustomerOrder order=orderDao.getCustomerOrderById(orderId);
		if (order != null) {
			ResponseStructure<CustomerOrder> structure = new ResponseStructure<CustomerOrder>();
			structure.setMessage("Order Fetched successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(order);
			return new ResponseEntity<ResponseStructure<CustomerOrder>>(structure, HttpStatus.FOUND);
		} else {
			throw new CartIdNotFoundException("Failed to fetch CustomerOrder");
		}
	}

	public ResponseEntity<ResponseStructure<CustomerOrder>> deleteOrderById(long orderId) {
		CustomerOrder order=orderDao.deleteCustomerOrder(orderId);
		if (order != null) {
			ResponseStructure<CustomerOrder> structure = new ResponseStructure<CustomerOrder>();
			structure.setMessage("CustomerOrder Deleted successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(order);
			return new ResponseEntity<ResponseStructure<CustomerOrder>>(structure, HttpStatus.OK);
		} else {
			throw new CartIdNotFoundException("Failed to delete CustomerOrder");
		}
	}
}
