package com.ritik.beans;
//bean class
public class Student {
	
	static {
		System.out.println("student Bean class loading---");
	}
	
	public Student() {
		System.out.println("bean object created without calling getbean() method");
		System.out.println("student Bean class Instantiation...");
		
	}
	
	private int sid;
	private String sname;
	private String saddress;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		System.out.println("sid property is initialized with"+ sid);
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		System.out.println("sname property is initialized with"+ sname);
		this.sname = sname;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		System.out.println("saddress property is initialized with"+ saddress);
		this.saddress = saddress;
	}

	public void getStudentDetails() {
		System.out.println("------------student details----------");
		System.out.println("student id: "+ sid);
		System.out.println("student name: "+ sname);
		System.out.println("student address: "+ saddress);
		
	}

}
