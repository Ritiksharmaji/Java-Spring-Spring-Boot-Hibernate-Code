package com.springcore_6.autowire.XML;

public class Address {
	
	private String street;
	private String city;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + "]";
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	//---------- note ----------
	// we are not going the create constructor because to inject it we will use the properties injection 
	//in-place of constructor injection
	

}
