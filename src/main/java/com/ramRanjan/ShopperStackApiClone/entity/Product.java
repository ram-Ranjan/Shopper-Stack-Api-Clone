package com.ramRanjan.ShopperStackApiClone.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedDate;

import com.ramRanjan.ShopperStackApiClone.enums.ProductSize;
import com.ramRanjan.ShopperStackApiClone.enums.ProductStatus;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	@ApiModelProperty(required = true)
	private String productTitle;
	@ApiModelProperty(required = true)
	private String productDescription;
	@ApiModelProperty(required = true)
	private double productPrice;
	@ApiModelProperty(required = true)
	private double productDiscount;
	@ApiModelProperty(required = true)
	@CreatedDate
	private LocalDate addedDate;
	@ApiModelProperty(required = true)
	private ProductSize productSize;
	@ApiModelProperty(required = true)
	private ProductStatus productStatus;
	@ApiModelProperty(required = true)
	private double productStock;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Category category;
	
	@ManyToMany(mappedBy = "products")
	private List<User> listOfUsers;
	@OneToMany
	private List<ProductReview> productReviews;
	

}
