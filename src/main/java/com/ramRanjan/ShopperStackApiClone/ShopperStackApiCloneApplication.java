package com.ramRanjan.ShopperStackApiClone;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ShopperStackApiCloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopperStackApiCloneApplication.class, args);
	}
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
