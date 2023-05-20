package com.ramRanjan.ShopperStackApiClone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ramRanjan.ShopperStackApiClone.dto.CustomerOrderDto;
import com.ramRanjan.ShopperStackApiClone.entity.CustomerOrder;
import com.ramRanjan.ShopperStackApiClone.service.CustomerOrderService;
import com.ramRanjan.ShopperStackApiClone.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/order")
public class CustomerOrderController {
	@Autowired
	private CustomerOrderService orderService;
	
	@ApiOperation(value = "Save CustomerOrder", notes = " Api is used to save the CustomerOrder")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully created"),
			@ApiResponse(code = 404, message = "CustomerOrder not found for the given  id") })
	@PostMapping
public ResponseEntity<ResponseStructure<CustomerOrder>> addCustomerOrder(@RequestParam long cartId,@RequestBody CustomerOrderDto orderDto){
		return orderService.addOrder(cartId, orderDto);
	}
	@ApiOperation(value = "Update CustomerOrder", notes = " Api is used to update the CustomerOrder")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Updated"),
			@ApiResponse(code = 404, message = "CustomerOrder not found for the given  id") })
	@PutMapping
	public ResponseEntity<ResponseStructure<CustomerOrder>> updateCustomerOrder(@RequestParam long orderId,@RequestBody CustomerOrderDto orderDto){
		return orderService.updateOrder(orderId, orderDto);
	}
	@ApiOperation(value = "Find CustomerOrder", notes = " Api is used to find the CustomerOrder")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Successfully fetched"),
			@ApiResponse(code = 404, message = "CustomerOrder not found for the given  id") })
	@GetMapping
	public ResponseEntity<ResponseStructure<CustomerOrder>> getCustomerOrder(@RequestParam long orderId){
		return orderService.getOrderById(orderId);
	}

	@ApiOperation(value = "Delete CustomerOrder", notes = " Api is used to delete the CustomerOrder")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully deleted"),
			@ApiResponse(code = 404, message = "CustomerOrder not found for the given  id") })
	@DeleteMapping
	public ResponseEntity<ResponseStructure<CustomerOrder>> deleteCustomerOrder(@RequestParam long orderId){
		return orderService.deleteOrderById(orderId);
	}

}
