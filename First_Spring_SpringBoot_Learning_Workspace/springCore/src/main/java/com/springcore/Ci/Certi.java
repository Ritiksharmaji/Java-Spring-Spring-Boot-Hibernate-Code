package com.springcore.Ci;

public class Certi {
	
	private String name;
	
	public Certi(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("---------------");
		this.name = name;
	}

	@Override
	public String toString() {
		return "this.name";
	}
	

}
