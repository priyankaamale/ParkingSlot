package com.parking_slot.main.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
	
	@NotNull(message = "Invalid registration number: registration no is NULL")
	@Pattern(regexp = "[A-Z]{2}\\s[0-9]{2}\\s[A-Z]{2}\\s[0-9]{4}",message = "Enter valid registration Number")
    private String registrationNumber;
	
	@NotNull(message = "Please Enter the color")
	@Size(min=3,max =15, message = "Invalid color: Must be of 3 - 15 characters")
     private  String color;
	
	@Valid
     private  parkingDetailsDto detailsDto; 
}
