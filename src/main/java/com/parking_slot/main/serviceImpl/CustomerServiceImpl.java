package com.parking_slot.main.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking_slot.main.dto.CustomerDto;
import com.parking_slot.main.dto.ParkingLotDto;
import com.parking_slot.main.exception.ErrorMessageException;
import com.parking_slot.main.exception.SlotNotFoundException;
import com.parking_slot.main.model.Customer;
import com.parking_slot.main.model.ParkingDetails;
import com.parking_slot.main.model.ParkingLot;
import com.parking_slot.main.model.Ticket;
import com.parking_slot.main.repository.CustomerRepository;
import com.parking_slot.main.repository.ParkingLotRepository;
import com.parking_slot.main.repository.TicketTRepository;
import com.parking_slot.main.repository.parkingDetailsRepository;
import com.parking_slot.main.response.CustomerResponse;
import com.parking_slot.main.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private TicketTRepository ticketTRepository;
	
	@Autowired
	private ParkingLotRepository parkingLotRepository;

	@Autowired
	private  ModelMapper modelMapper;
	
	@Override
	public CustomerDto createCustomer(CustomerDto request) {
		
	Customer customer =	modelMapper.map(request, Customer.class);
	
    List<Ticket> tickets = ticketTRepository.findBySlotNo(customer.getTicket().getSlotNo());
    
   ParkingLot parkingLot = parkingLotRepository.findById(customer.getTicket().getSlotNo())
   .orElseThrow(() -> new ErrorMessageException("Enter valid Slot No !"));
   
     
   long count = tickets.stream().filter(park -> park.isCarPark() == true).count();
		
   if( count < parkingLot.getCapacity() ) {
	   customer.getTicket().getCar().getParkingDetails().setEntryDateTime(LocalDateTime.now());
		customer.getTicket().setCarPark(true);
		
		Customer cust =	 customerRepo.save(customer);
		return modelMapper.map(cust, CustomerDto.class);   
   }
   else {
       throw new SlotNotFoundException("parking slot full");

   }
	}
	
	

	@Override
	public List<CustomerResponse> getAllCustomer() {
		List<Customer> customers = customerRepo.findAll();
		if(customers.isEmpty()) {
			throw new ErrorMessageException("No customer is present! ");
		}
			 
	
		 return customers.stream().map(cust -> 
		 modelMapper.map(cust, CustomerResponse.class))
				 .collect(Collectors.toList());
	}

	
}

