package com.ritik.beans;

// bean class
public class Employee {
	private int eno;
	private String ename;
	private String eaddress;
	private float esalary;
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEaddress() {
		return eaddress;
	}
	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}
	public float getEsalary() {
		return esalary;
	}
	public void setEsalary(float esalary) {
		this.esalary = esalary;
	}
	// business methods...
	public void getEmplydetals() {
		System.out.println("------------employee details--------------");
		System.out.println("employee no: "+ eno);
		System.out.println("employee name: "+ ename);
		System.out.println("employee address: "+ eaddress);
		System.out.println("employee salary: "+ esalary);
		
	}

}
