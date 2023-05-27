package com.ramRanjan.ShopperStackApiClone.dto;

import java.util.List;

import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class WishlistDto {
	
	private long wishlistId;
	private String wishlistTitle;
	@OneToMany
	private List<ProductDto> products;
	

}
