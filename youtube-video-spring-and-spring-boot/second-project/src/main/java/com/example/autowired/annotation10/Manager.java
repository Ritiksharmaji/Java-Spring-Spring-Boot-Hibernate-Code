package com.example.autowired.annotation10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Manager {
	
	private Employee employee;

	// the @Autowired we can use on the constructor and fileds as well
//	@Autowired  --- this is the field Autowired
//	private Employee employee;
	
	// this is constructor autowired
	@Autowired
	public Manager(Employee employee) {
		super();
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Manager [employee=" + employee + "]";
	}
	
	
	
	

}
