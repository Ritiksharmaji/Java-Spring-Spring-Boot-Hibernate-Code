package com.example.autowire.Type_6;

public class Car {
	
	// autowiring by type don't need to object name and bean name same 
	private Specification spe;
	
//	public Car(Specification specification) {
//		super();
//		this.Specification = specification;
//	}
	
	// without setter it can't set the value of its fields..
		public void setSpecification(Specification specification) {
			this.spe = specification;
		}

	public void displayDetails() {
		System.out.println("Car details by autowiring ByType:"+ spe.toString());
	}

	

}
