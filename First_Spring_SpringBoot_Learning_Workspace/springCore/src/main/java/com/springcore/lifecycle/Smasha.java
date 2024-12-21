package com.springcore.lifecycle;
public class Smasha {
	private double price;
	public double getPrice() {
		return price;
	}
	@Override
	public String toString() {
		return "Smasha [price=" + price + "]";
	}
	public void setPrice(double price) {
		System.out.println("---- properties setting-----");
		this.price = price;
	}
	// without default constructor will give error..w
	public Smasha() {
		super();
	}
	public Smasha(double price) {
		
		this.price = price;
	}
	
	// creating life-cycle method
	public void init() {
		System.out.println("inside the init() method of Smasha");
	}
	public void destroy() {
		System.out.println("inside the destroy() method of Smasha");
	}
}
