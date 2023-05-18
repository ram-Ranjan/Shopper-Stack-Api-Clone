package com.ramRanjan.ShopperStackApiClone.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CustomerOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerOrderId;
	private LocalDateTime customerOrderDate;
	private String customerOrderStatus;
	@ManyToOne
	private CustomerCart cart;
	
	

}
