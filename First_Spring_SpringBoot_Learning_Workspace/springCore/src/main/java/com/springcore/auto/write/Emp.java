package com.springcore.auto.write;

public class Emp {
	private Address address;
	// generating de-fault constructor
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	@Override
	public String toString() {
		return "Emp [address=" + address + "]";
	}

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	// generating parameterizi constructor
	public Emp(Address address) {
		super();
		this.address = address;
		System.out.println("inside the parametarize constructor");
	}
	

}
