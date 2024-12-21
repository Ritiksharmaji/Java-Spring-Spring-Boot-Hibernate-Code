package com.springcore.Ci;

public class Addition {
	
	private int a;
	private int b;
	
	public Addition(double a, double b) {
		super();
		this.a = (int)a;
		// typecast
		this.b = (int)b;
		System.out.println("double,double constructor call:");
	}
	public Addition(int a, int b) {
		super();
		this.a = a;
		this.b = b;
		System.out.println("int,int constructor call:");
	}
	public Addition(String a, String b) {
		super();
		this.a = Integer.parseInt(a);
		this.b = Integer.parseInt(b);
		System.out.println("string,string constructor call:");
	}
	
	public void RKJ_Sum() {
		System.out.println("value of a variable: " + a);
		System.out.println("value of b variable: " + b);
		System.out.println("Addition of both numbers: " + (this.a + this.b));
	}
	
}
