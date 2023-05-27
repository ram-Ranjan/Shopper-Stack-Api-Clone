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

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	private double discountedPrice;
	@ApiModelProperty(required = true)
	@CreatedDate
	private LocalDate addedDate;
	@ApiModelProperty(required = true)
	private ProductSize productSize;
	@ApiModelProperty(required = true)
	private ProductStatus productStatus;
	@ApiModelProperty(required = true)
	private double productStock;
	private int productQuantity;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Category category;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "product")
	@JsonIgnore
	private List<CustomerProduct> customerProduct;
	
	@ManyToOne
	@JsonIgnore
	private List<User> listOfUsers;
	
	@OneToMany
	private List<ProductReview> productReviews;
	

}
