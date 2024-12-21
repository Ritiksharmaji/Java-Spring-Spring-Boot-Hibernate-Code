package com.springcore.springCore;
public class First {
	
	private int student_id;
	private String studentName;
	private String student_Adds;
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudent_Adds() {
		return student_Adds;
	}
	public void setStudent_Adds(String student_Adds) {
		this.student_Adds = student_Adds;
	}
	public First() {
		super();
		// TODO Auto-generated constructor stub
	}
	public First(int student_id, String studentName, String student_Adds) {
		super();
		this.student_id = student_id;
		this.studentName = studentName;
		this.student_Adds = student_Adds;
	}
	/*
	 * here are using the toString method which convert the reference to string or object 
	 */
	@Override
	public String toString() {
		return "First [student_id=" + student_id + ", studentName=" + studentName + ", student_Adds=" + student_Adds
				+ "]";
	}
	
	

}
