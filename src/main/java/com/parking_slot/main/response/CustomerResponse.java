package com.parking_slot.main.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {

	 private int id;

	    private String firstName;

	    private String lastName;

	    private String contactNumber;

}
