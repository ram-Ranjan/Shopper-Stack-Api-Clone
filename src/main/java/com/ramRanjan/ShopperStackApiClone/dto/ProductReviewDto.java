package com.ramRanjan.ShopperStackApiClone.dto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class ProductReviewDto {

	private long reviewId;
	private int reviewRating;
	private String reviewComment;
	private LocalDate reviewDate;

}
