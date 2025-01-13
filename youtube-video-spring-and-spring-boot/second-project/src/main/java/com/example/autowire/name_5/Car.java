package com.example.autowire.name_5;

public class Car {
	
	// this object name must be same of bean name otherwise it can't work.
	private Specification specification;
	
//	public Car(Specification specification) {
//		super();
//		this.Specification = specification;
//	}
	
	// without setter it can't set the value of its fields..
		public void setSpecification(Specification specification) {
			this.specification = specification;
		}

	public void displayDetails() {
		System.out.println("Car details:"+ specification.toString());
	}

	

}
