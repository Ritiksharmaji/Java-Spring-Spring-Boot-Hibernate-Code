package com.Assigment.entity;

import jakarta.persistence.*;


@Entity
@Table
public class Admission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String dob;
    private String email;
    private String mobile;
    private String address;
    private String course;

    private String photoPath;
    private String signaturePath;
    private String password;
    
	public Admission(Long id, String name, String dob, String email, String mobile, String address, String course,
			String photoPath, String signaturePath, String password) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.course = course;
		this.photoPath = photoPath;
		this.signaturePath = signaturePath;
		this.password = password;
	}

	public Admission() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public String getSignaturePath() {
		return signaturePath;
	}

	public void setSignaturePath(String signaturePath) {
		this.signaturePath = signaturePath;
	}

	

	public void setPassword(String password) {
		this.password = password;
	}

	public CharSequence getPassword() {
		return password;
	}
    
	
	
    
}
