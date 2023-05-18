package com.ramRanjan.ShopperStackApiClone.dto;

import java.util.List;

import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import com.ramRanjan.ShopperStackApiClone.entity.CustomerOrder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class CustomerCartDto {
	private long customerCartId;
	private double customerCartSubTotal;
	private long customerCartQuantity;
	private double customerCartDiscount;
	private double customerCartTotal;
	@OneToMany
	private List<CustomerOrder> customerOrders;
}
