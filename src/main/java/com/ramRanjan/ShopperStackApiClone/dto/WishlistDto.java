package com.ramRanjan.ShopperStackApiClone.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import com.ramRanjan.ShopperStackApiClone.entity.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class WishlistDto {
	
	private long wishlistId;
	@OneToMany
	private List<Product> products;
	

}
