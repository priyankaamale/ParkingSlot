package com.parking_slot.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parking_slot.main.model.Customer;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer, Integer>{

}
