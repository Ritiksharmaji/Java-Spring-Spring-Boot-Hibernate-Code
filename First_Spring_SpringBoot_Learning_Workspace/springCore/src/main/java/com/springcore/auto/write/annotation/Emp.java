package com.springcore.auto.write.annotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
public class Emp {
	@Autowired
	@Qualifier("address2")
	private Address address;
	// generating de-fault constructor
	public Emp() {
		super();
	}
	@Override
	public String toString() {
		return "Emp [address=" + address + "]";
	}
	public Address getAddress() {
		return address;
	}
	// apply the @Autowired on setter method
	@Autowired
	@Qualifier("address3")
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
