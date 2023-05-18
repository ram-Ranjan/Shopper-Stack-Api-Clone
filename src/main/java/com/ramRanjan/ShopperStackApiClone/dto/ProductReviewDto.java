package com.ramRanjan.ShopperStackApiClone.dto;

import java.time.LocalDate;

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
