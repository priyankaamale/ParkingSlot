package com.parking_slot.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parking_slot.main.model.Ticket;

@Repository
public interface TicketTRepository extends JpaRepository<Ticket, Long>{

	List<Ticket> findAllByCar_Color(String color);

	List<Ticket> findBySlotNo(int slotNo);

	
}
