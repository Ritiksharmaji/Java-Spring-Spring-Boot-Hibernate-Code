package com.springcore.Ci;

public class Person {
	
	private String name;
	private int personId;
	private Certi certi;
	
public Person(String name,int personId,Certi certi) {
		
		this.name=name;
		this.personId = personId;
		this.certi = certi;
	}
	
// create a toString method to print the properties of bean Person class.
	@Override
	public String toString() {
		//return "Person [name=" + name + ", personId=" + personId + "]";
		return this.name + " : " + this.personId +"{" + this.certi.getName()+"}";
	}
	
	

}
