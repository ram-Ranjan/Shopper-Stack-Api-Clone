package com.ramRanjan.ShopperStackApiClone.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class CustomerOrderDto {
	private long customerOrderId;
	private LocalDateTime customerOrderDate;
	private String customerOrderStatus;

}
