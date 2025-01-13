package com.spring.orm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// to make it as entity
@Entity
// to give table name
@Table(name="student")
public class Student {
	
	@Id
	//@Column(name="student_id")
	@Column(name="id")
	private int studentId;
	//@Column(name="stundet_name")
	@Column(name="name")
	private String studentName;
	//@Column(name="student_city")
	@Column(name="city")
	private String studentCity;
	
	public Student() {
		//super();
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentCity() {
		return studentCity;
	}

	public void setStudentCity(String studentCity) {
		this.studentCity = studentCity;
	}

	public Student(int studentId, String studentName, String studentCity) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentCity = studentCity;
	}

}
