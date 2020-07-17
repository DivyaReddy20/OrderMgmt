package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.CustomerInfo;
import com.example.exception.InvalidDetailsException;
import com.example.service.OrderService;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:4200")
	

public class OrderController {
	
	@Autowired
	OrderService service;
	
	@PostMapping("/update")
	public ResponseEntity<Boolean> updating(@RequestBody CustomerInfo customer) {
		customer.setCustomerId(customer.getCustomerId());
		customer = service.updateCustomerInfo(customer);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		System.out.println("response entity=" + responseEntity);
		return responseEntity;
	}
	@GetMapping("/get/{customerId}")
	public String displayCustomerInfo(@PathVariable Integer customerId) throws InvalidDetailsException {	
		Boolean info=service.getCustomerInfo(customerId);
		if(Boolean.TRUE.equals(info))
		{
		CustomerInfo data = service.displayOneInfo(customerId);
		return "Default Shipping Address Of the customer"+ data.customerInfo();
		}
		else {
			throw new InvalidDetailsException("enter proper customer Id!!!!!!!!!");
		}
	}
	
	}
		
	
