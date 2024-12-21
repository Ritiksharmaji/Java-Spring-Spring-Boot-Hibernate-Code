package com.blogapp.apis.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{

	String resourceName;
	String fieldName;
	long fieldValue;
	String stringname;
	public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
		
		super(String.format("%s not found with %s : %s", resourceName,fieldName,fieldValue));
		
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	/*
	 * this method for handle the exception of Role where we are having the user as email do we have create third arg as string
	 */
public ResourceNotFoundException(String resourceName, String fieldName, String stringname) {
		
		super(String.format("%s not found with %s : %s", resourceName,fieldName,stringname));
		
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.stringname = stringname;
	}
	
}
