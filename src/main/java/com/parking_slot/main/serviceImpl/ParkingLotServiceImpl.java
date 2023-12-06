package com.parking_slot.main.serviceImpl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking_slot.main.dto.ParkingLotDto;
import com.parking_slot.main.dto.parkingDetailsDto;
import com.parking_slot.main.exception.CustomerNotFoundException;
import com.parking_slot.main.exception.ErrorMessageException;
import com.parking_slot.main.exception.TicketNotFoundException;
import com.parking_slot.main.model.Car;
import com.parking_slot.main.model.ParkingDetails;
import com.parking_slot.main.model.ParkingLot;
import com.parking_slot.main.model.Ticket;
import com.parking_slot.main.repository.CarRepository;
import com.parking_slot.main.repository.ParkingLotRepository;
import com.parking_slot.main.repository.TicketTRepository;
import com.parking_slot.main.repository.parkingDetailsRepository;
import com.parking_slot.main.response.CarResponse;
import com.parking_slot.main.response.ParkingDetailsResponse;
import com.parking_slot.main.response.ParkingLotresponse;
import com.parking_slot.main.service.ParkingLotService;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {
	
	@Autowired
	private ParkingLotRepository parkingLotRepository;
	
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private parkingDetailsRepository parkingDetailsRepository;
	
	@Autowired
	private TicketTRepository ticketTRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ParkingLotDto createParkingLot(ParkingLotDto parkDto) {
		ParkingLot parkingLot = modelMapper.map(parkDto, ParkingLot.class);
		ParkingLot lot = parkingLotRepository.save(parkingLot);
		
		return modelMapper.map(lot, ParkingLotDto.class);
	}
	
	@Override
	public List<ParkingLotresponse> findAllParkingLots() {
		List<ParkingLot> parkingLot = parkingLotRepository.findAll();
		if (parkingLot.isEmpty()) {
			throw new ErrorMessageException("emty parking lots");
		}
		return parkingLot.stream().map(park ->
		modelMapper.map(park, ParkingLotresponse.class))
				.collect(Collectors.toList());


	}
	
	@Override
	public List<CarResponse> getRegistrationNumbersByColor(String color) {
		List<Car> car = carRepository.findAllByColor(color);
		
		return car.stream().map(vehicle ->
		modelMapper.map(vehicle, CarResponse.class))
				.collect(Collectors.toList());
	}

	@Override
	public ParkingDetailsResponse calculateCharges(int id) {
		 ParkingDetails dto = parkingDetailsRepository.findById(id)
				.orElseThrow(()-> new CustomerNotFoundException("Invalid Ticket Id"));
		
			//parkingDetailsDto dto = modelMapper.map(parkingDetails, parkingDetailsDto.class);
			
			
			LocalDateTime exitTime = LocalDateTime.now();

			Duration duration = Duration.between(exitTime, dto.getEntryDateTime());
			long hour = (Math.abs(duration.getSeconds())/60)/60;
			
			int chargeperHour = dto.getChargeperHour();
			
			dto.setExitDateTime(LocalDateTime.now());
			dto.setTotalHour(hour);
			
					if(hour == 0) {
				dto.setTotalCharges(chargeperHour);
			}
			else {
				dto.setTotalCharges((int) (hour*chargeperHour));	
			}
			
			
			Ticket ticket = ticketTRepository.findById((long) dto.getId()).get();
			ticket.setCarPark(false);
			
			ParkingDetails details = parkingDetailsRepository.save( modelMapper.map(dto, ParkingDetails.class));
		return	modelMapper.map(details, ParkingDetailsResponse.class);
		
		
	}

	@Override
	public List<Long> getTicketNumbersByColor(String color) {
		
	 List<Long> ticketNumbers = new ArrayList<>();
		List<Ticket> byColor = ticketTRepository.findAllByCar_Color(color);
		
		byColor.forEach(no -> ticketNumbers.add(no.getId()));
		
		
		return ticketNumbers;
	}

	@Override
	public Long getTicketNumberByRegistrationNumber(String registrationNumber) {
	Optional<Car> car = carRepository.findByRegistrationNumber(registrationNumber);
		if(car.isPresent()) {
		Car id = car.get();
		  Ticket ticket = ticketTRepository.findById((long) id.getId()).get();
		  return ticket.getId();
	}
		else {
			throw new TicketNotFoundException("Enter valid Registration No") ;
		}
		
	}

	

	

	
}
