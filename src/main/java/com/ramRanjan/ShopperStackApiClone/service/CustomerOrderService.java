package com.ramRanjan.ShopperStackApiClone.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ramRanjan.ShopperStackApiClone.dao.CustomerCartDao;
import com.ramRanjan.ShopperStackApiClone.dao.CustomerOrderDao;
import com.ramRanjan.ShopperStackApiClone.dao.UserDao;
import com.ramRanjan.ShopperStackApiClone.dto.CustomerOrderDto;
import com.ramRanjan.ShopperStackApiClone.entity.CustomerCart;
import com.ramRanjan.ShopperStackApiClone.entity.CustomerOrder;
import com.ramRanjan.ShopperStackApiClone.entity.CustomerProduct;
import com.ramRanjan.ShopperStackApiClone.entity.Product;
import com.ramRanjan.ShopperStackApiClone.entity.User;
import com.ramRanjan.ShopperStackApiClone.enums.OrderStatus;
import com.ramRanjan.ShopperStackApiClone.enums.UserRole;
import com.ramRanjan.ShopperStackApiClone.exception.CartIdNotFoundException;
import com.ramRanjan.ShopperStackApiClone.exception.OrderIdNotFoundException;
import com.ramRanjan.ShopperStackApiClone.exception.UserIdNotFoundException;
import com.ramRanjan.ShopperStackApiClone.util.ResponseStructure;

@Service
public class CustomerOrderService {
	@Autowired
	private CustomerOrderDao orderDao;
	@Autowired
	private CustomerCartDao cartDao;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private UserDao userDao;

	public ResponseEntity<ResponseStructure<List<CustomerOrder>>> addOrder(long cartId, CustomerOrderDto orderDto) {

		CustomerCart cart = cartDao.findCart(cartId);
		if (cart != null) {

			List<CustomerProduct> productList = cart.getCustomerProducts();
			List<CustomerOrderDto> orderDtos = new ArrayList<>();
			for (CustomerProduct product : productList) {

				CustomerOrder order = this.modelMapper.map(orderDto, CustomerOrder.class);
				order.setCustomerOrderDate(LocalDateTime.now());
				order.setOrderStatus(OrderStatus.PACKING);
				order.setProductId(product.getProductId());

				order = orderDao.saveCustomerOrder(order);

				orderDto = this.modelMapper.map(order, CustomerOrderDto.class);
				orderDtos.add(orderDto);
			}
			ResponseStructure<List<CustomerOrder>> structure = new ResponseStructure<List<CustomerOrder>>();
			structure.setMessage("Ordered  successfully");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(orderDtos);
			return new ResponseEntity<ResponseStructure<List<CustomerOrder>>>(structure, HttpStatus.CREATED);
		} else
			throw new CartIdNotFoundException("failed to order!");

	}

	public ResponseEntity<ResponseStructure<CustomerOrder>> updateOrder(long orderId, OrderStatus orderStatus,
			long userId) {

		User existingUser = userDao.findUserById(userId);
		if (existingUser != null && existingUser.getUserRole().equals(UserRole.MERCHANT)) {

			CustomerOrder dbOrder = orderDao.getCustomerOrderById(orderId);
			if (dbOrder != null) {

				dbOrder.setOrderStatus(orderStatus);
				orderDao.updateCustomerOrder(orderId, dbOrder);
				ResponseStructure<CustomerOrder> structure = new ResponseStructure<CustomerOrder>();
				structure.setMessage("Order updated successfully");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(dbOrder);
				return new ResponseEntity<ResponseStructure<CustomerOrder>>(structure, HttpStatus.OK);
			} else
				throw new OrderIdNotFoundException("Failed to update Order");
		} else
			throw new UserIdNotFoundException("Merchant not found");
	}

	public ResponseEntity<ResponseStructure<CustomerOrder>> getOrderById(long orderId) {
		CustomerOrder order = orderDao.getCustomerOrderById(orderId);
		if (order != null) {
			ResponseStructure<CustomerOrder> structure = new ResponseStructure<CustomerOrder>();
			structure.setMessage("Order Fetched successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(order);
			return new ResponseEntity<ResponseStructure<CustomerOrder>>(structure, HttpStatus.FOUND);
		} else
			throw new CartIdNotFoundException("Failed to fetch CustomerOrder");

	}

	public ResponseEntity<ResponseStructure<CustomerOrder>> deleteOrderById(long orderId) {
		CustomerOrder order = orderDao.deleteCustomerOrder(orderId);
		if (order != null) {
			ResponseStructure<CustomerOrder> structure = new ResponseStructure<CustomerOrder>();
			structure.setMessage("CustomerOrder Deleted successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(order);
			return new ResponseEntity<ResponseStructure<CustomerOrder>>(structure, HttpStatus.OK);
		} else
			throw new CartIdNotFoundException("Failed to delete CustomerOrder");
	}
}
