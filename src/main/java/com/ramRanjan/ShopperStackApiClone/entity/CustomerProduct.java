package com.ramRanjan.ShopperStackApiClone.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CustomerProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	private int productQuantity;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Product product;
	
	@ManyToMany
	private List<CustomerCart> cartsList;


}
