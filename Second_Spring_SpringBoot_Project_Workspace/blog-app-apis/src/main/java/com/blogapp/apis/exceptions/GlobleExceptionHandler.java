package com.blogapp.apis.exceptions;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blogapp.apis.payloads.ApiREsponse;

@RestControllerAdvice
public class GlobleExceptionHandler {
	
	/*
	 * to handle the Error type of Resource Not Found Error
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiREsponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
	
		// getting the SMS from ResourceNotFoundException
		String message = ex.getMessage();
		
		// creating object for ApiREsponse class
		ApiREsponse apiresponse = new ApiREsponse(message,false);
		/*so when ever server give the page not found error than
		 * this method will run and return the below response.
		 */
		return new ResponseEntity<ApiREsponse>(apiresponse,HttpStatus.NOT_FOUND);
	}
	
	/*to handle the MethodArgumentNotValidException 
	 * 
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		
		/*
		 * to stored all fields error
		 */
		Map<String,String> response = new HashMap<>();
		// getting all the errors
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName = ((FieldError)error).getField();
			String defaultMessage = error.getDefaultMessage();
			
			response.put(fieldName, defaultMessage);
		});
		return new ResponseEntity<Map<String,String>>(response,HttpStatus.BAD_REQUEST);
	}	
}
