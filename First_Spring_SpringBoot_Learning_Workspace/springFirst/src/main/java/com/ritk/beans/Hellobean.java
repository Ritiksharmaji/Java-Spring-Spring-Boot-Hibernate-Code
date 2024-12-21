package com.ritk.beans;

public class Hellobean {
	
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getString() {
		return "Ritik sjarma";
	}
	
	public String getName() {
		return "Hello "+name+"!";
	}

}
