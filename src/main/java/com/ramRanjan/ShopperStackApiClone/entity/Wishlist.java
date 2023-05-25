package com.ramRanjan.ShopperStackApiClone.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.ramRanjan.ShopperStackApiClone.dto.ProductDto;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Wishlist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long wishlistId;
	
	private String wishlistTitle;
	
	@ManyToMany
	private List<Product> products;
	
	@ManyToOne
	private User user;
	
}
