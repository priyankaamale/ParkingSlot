package com.parking_slot.main.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parking_slot.main.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer>{

	List<Car> findAllByColor(String color);

	Optional<Car> findByRegistrationNumber(String registrationNumber);

	
}
