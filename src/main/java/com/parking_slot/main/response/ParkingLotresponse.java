package com.parking_slot.main.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingLotresponse {
	
	private int id;

    private String slots;
    
    private int capacity;

}
