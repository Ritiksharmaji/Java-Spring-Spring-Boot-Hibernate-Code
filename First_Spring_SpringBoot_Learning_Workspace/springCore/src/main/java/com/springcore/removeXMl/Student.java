package com.springcore.removeXMl;

import org.springframework.stereotype.Component;

public class Student {
	
	private Smosa smasa;

	public Student(Smosa smasa) {
		super();
		this.smasa = smasa;
	}
	public Smosa getSmasa() {
		System.out.println("this is smosa class getmethod:");
		return smasa;
	}

	public void setSmasa(Smosa smasa) {
		this.smasa = smasa;
	}

	public void study() {
		System.out.println("student is doing study...");
		System.out.println("configuration bu other ways--");
	}

}
