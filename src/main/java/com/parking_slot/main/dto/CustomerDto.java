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
public class CustomerDto {
	@NotNull
	private int id;
	
	@NotNull(message = "Invalid Name: First Name is NULL")
	@Size(min=3,max = 30, message = "Invalid FirstName: Must be of 3 - 30 characters")
	private String firstName;
	
	@NotNull(message = "Invalid Name: Last Name is NULL")
	@Size(min=3,max = 30, message = "Invalid LastName: Must be of 3 - 30 characters")
	private String lastName;
	
	@NotNull(message = "Invalid Phone number: Contact no is NULL")
	@Pattern(regexp = "[7-9]{1}[0-9]{9}",message = "Enter valid mobile no" )
	private String contactNumber;
     
	@Valid 
	private TicketDto ticketDto;
    

}
