package com.example.componentScan_8;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	@Value("20")
    private int employeeId;
    
    @Value("Ritik")
    private String FirstName;
    
    @Value("Sharma")
    private String LastName;
    
    @Value("4000")
    private double salary;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", FirstName=" + FirstName + ", LastName=" + LastName
				+ ", salary=" + salary + "]";
	}
	
	
	

}