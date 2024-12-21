package com.springcore.stereotype;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("obj")
@Scope("prototype")
public class Student {
	@Value("Ritik ji sharma")
	private String Studentname;
	@Value("Siwan city")
	private String city;
	
	@Value("#{myaddress}")
	private List<String>address;
	
	public List<String> getAddress() {
		return address;
	}
	public void setAddress(List<String> address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Student [Studentname=" + Studentname + ", city=" + city + ", address=" + address + "]";
	}
	public String getStudentname() {
		return Studentname;
	}
	public void setStudentname(String studentname) {
		Studentname = studentname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	

}
