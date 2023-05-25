package com.ramRanjan.ShopperStackApiClone.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ramRanjan.ShopperStackApiClone.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> addressIdNotFoundException(AddressIdNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage(ex.getMessage());
		structure.setData("Sorry!! Address Id Not Found");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> cartIdNotFoundException(CartIdNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage(ex.getMessage());
		structure.setData("Sorry!! Cart Id Not Found");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> userStatusBlockedException(UserStatusBlockedException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage(ex.getMessage());
		structure.setData("Sorry!! User Status is Blocked");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> productAlreadyExistingException(ProductAlreadyExistingException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage(ex.getMessage());
		structure.setData("Sorry!! Product already exist in wishlist");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> orderIdNotFoundException(OrderIdNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage(ex.getMessage());
		structure.setData("Sorry!! Order Id Not Found");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> productIdNotFoundException(ProductNotFoundByIdException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage(ex.getMessage());
		structure.setData("Sorry!! Product Id Not Found");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> userIdNotFoundException(UserIdNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage(ex.getMessage());
		structure.setData("Sorry!! User Id Not Found");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> userNotFoundByIdException(UserNotFoundByIdException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage(ex.getMessage());
		structure.setData("Sorry!! User Id Not Found");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> categoryNotFoundByIdException(CategoryNotFoundByIdException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage(ex.getMessage());
		structure.setData("Sorry!!  Category not found with given id");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> categoryCanNotBeDeletedException(CategoryCanNotBeDeletedException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage(ex.getMessage());
		structure.setData("Sorry!!  Category cant be deleted");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> userIsNotCustomerException(UserIsNotCustomerException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage(ex.getMessage());
		structure.setData("Sorry!! User is not a customer");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> userIsNotAdminException(UserIsNotAdminException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage(ex.getMessage());
		structure.setData("Sorry!! User should be Admin");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> userIsNotMerchantException(UserIsNotMerchantException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage(ex.getMessage());
		structure.setData("Sorry!! User should be Merchant");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> wishListNotFoundByIdException(WishlistNotFoundByIdException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage(ex.getMessage());
		structure.setData("Sorry!! WishList Id Not Found");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

}
