package com.springcore.springCore;

public class first_spring {
	
	
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
	public first_spring(int student_id, String studentName, String student_Adds) {
		super();
		this.student_id = student_id;
		this.studentName = studentName;
		this.student_Adds = student_Adds;
	}

}
