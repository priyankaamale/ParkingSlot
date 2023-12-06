package com.parking_slot.main.service;

import java.util.List;

import com.parking_slot.main.dto.CustomerDto;
import com.parking_slot.main.response.CustomerResponse;

public interface CustomerService {

	CustomerDto createCustomer(CustomerDto request);

	List<CustomerResponse> getAllCustomer();

	

	

}
