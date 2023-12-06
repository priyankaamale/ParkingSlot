package com.parking_slot.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.parking_slot.main.dto.ParkingLotDto;
import com.parking_slot.main.response.CarResponse;
import com.parking_slot.main.response.ParkingDetailsResponse;
import com.parking_slot.main.response.ParkingLotresponse;
import com.parking_slot.main.service.ParkingLotService;

@RestController
@RequestMapping("/parking-lots")
public class ParkingLotController {

	@Autowired
	private ParkingLotService parkingLotService;
	
	
	@PostMapping("/addslot")
	public ResponseEntity<ParkingLotDto> createParkingLot(@RequestBody ParkingLotDto parkDto) {
		        return new ResponseEntity<ParkingLotDto>(parkingLotService.createParkingLot(parkDto),
        		HttpStatus.CREATED);
    }
	

	@GetMapping("/getslots")
    public ResponseEntity<List<ParkingLotresponse>> findAllParkingLots() {
        List<ParkingLotresponse> parkingLots = parkingLotService.findAllParkingLots();

                return new ResponseEntity<List<ParkingLotresponse>>(parkingLots,HttpStatus.OK);
    }
	
	 @GetMapping("/cars/{color}")
	 public ResponseEntity<List<CarResponse>> getRegistrationNumbersByColor(@PathVariable(value = "color") String color){
		 return new ResponseEntity<List<CarResponse>>(
				 parkingLotService.getRegistrationNumbersByColor(color),
				 HttpStatus.OK);
	 }
	 
	 @GetMapping("/calculateCharges/{id}")
	 public ResponseEntity<ParkingDetailsResponse> calculateCharges(@PathVariable int id){
		 return new ResponseEntity<ParkingDetailsResponse>(
				 parkingLotService.calculateCharges(id),
				 HttpStatus.OK);
	 }
	 
	 
	 
	 @GetMapping("/ticket/{color}")
	 public ResponseEntity<List<Long>> getTicketNumbersByColor(@PathVariable(value = "color") String color){
		 return new ResponseEntity<List<Long>>(
				 parkingLotService.getTicketNumbersByColor(color),
				 HttpStatus.OK);
	 }
	
	 @GetMapping("/ticket/regiNo/{registrationNumber}")
	 public ResponseEntity<Long> getTicketNumberByRegistrationNumber(@PathVariable String registrationNumber){
		 return new ResponseEntity<Long>(
				 parkingLotService.getTicketNumberByRegistrationNumber(registrationNumber),
				 HttpStatus.OK);
	 }
}
