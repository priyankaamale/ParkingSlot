package com.parking_slot.main.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parking_slot.main.dto.CustomerDto;
import com.parking_slot.main.model.Customer;
import com.parking_slot.main.response.CustomerResponse;
import com.parking_slot.main.service.CustomerService;

import jakarta.validation.Valid;

@RestController
public class CustomerController {
	
	 @Autowired
	 private CustomerService customerService;
	

	 @PostMapping("/addCust")
	    public ResponseEntity<String> createCustomer(@Valid @RequestBody CustomerDto request) {
		 
		 CustomerDto customerDto = customerService.createCustomer(request);
	         return new ResponseEntity<String>("Car park Successfully!", HttpStatus.OK);
	         
	    }
	 
	 
	 @GetMapping("/customers")
	 public ResponseEntity<List<CustomerResponse>> getAllCutomers(){
		 return new ResponseEntity<List<CustomerResponse>>(
				 customerService.getAllCustomer(),
				 HttpStatus.OK);
	 }

}
