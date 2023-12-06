package com.parking_slot.main.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({
	"success",
	"message"
})
public class ApiResponse {
	@JsonProperty("success")
	private Boolean success;

	@JsonProperty("message")
	private String message;


}
