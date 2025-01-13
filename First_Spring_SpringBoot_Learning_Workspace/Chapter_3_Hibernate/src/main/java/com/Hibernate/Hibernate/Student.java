package com.Hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
//@Entity(name="student_details")
//@Table(name="students")
public class Student {
	public Certificate getCertifi() {
		return certifi;
	}
	public void setCertifi(Certificate certifi) {
		this.certifi = certifi;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", city=" + city + ", certifi=" + certifi + "]";
	}
	@Id
	private int id;
	private String name;
	private String city;
	private Certificate certifi;
	public Student(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	

}
