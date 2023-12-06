package com.parking_slot.main.exception;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.parking_slot.main.response.ApiResponse;

@RestControllerAdvice
public class GlobalException {
	
	
	@ExceptionHandler(ErrorMessageException.class)
	@ResponseBody
	public ResponseEntity< ApiResponse> resolveException(ErrorMessageException exception){
		ApiResponse apiResponse = exception.getApiResponse();
		
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,List<String>> handleValidationErrors(MethodArgumentNotValidException ex){
		
		Map<String,List<String>> error = new HashMap<>();
		
		 List<String> errors = ex.getBindingResult().getFieldErrors()
	                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
		 	error.put("errors", errors);

		return error;
	}
	
	@ExceptionHandler(SlotNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiErrorResponse> handleCustomException(SlotNotFoundException ex) {
		ApiErrorResponse apir= new ApiErrorResponse(404,"Slot is Full Enter Another Slot!",LocalDate.now());
        return new ResponseEntity<ApiErrorResponse>(apir, HttpStatus.BAD_REQUEST);
    }
	
	
	@ExceptionHandler(CustomerNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiErrorResponse> handleCustomerException(CustomerNotFoundException ex) {
		ApiErrorResponse apir= new ApiErrorResponse(404,"Customer is not available enter proper id !",LocalDate.now());
        return new ResponseEntity<ApiErrorResponse>(apir, HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(TicketNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiErrorResponse> handleCustomerException(TicketNotFoundException ex) {
		ApiErrorResponse apir= new ApiErrorResponse(404,"Ticket Not Found please enter proper registration no!",LocalDate.now());
        return new ResponseEntity<ApiErrorResponse>(apir, HttpStatus.BAD_REQUEST);
    }
	
	
}
	
	
	
	

	