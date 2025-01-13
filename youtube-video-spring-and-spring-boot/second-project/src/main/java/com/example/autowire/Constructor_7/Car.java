package com.example.autowire.Constructor_7;

public class Car {
	
	// autowiring by type don't need to object name and bean name same 
	private Specification spe;
	

// constructor for autowiring 
	public Car(Specification spe) {
		super();
		this.spe = spe;
	}



	public void displayDetails() {
		System.out.println("Car details by autowiring ByConstuctor:"+ spe.toString());
	}

	

}
