package com.springcore.jdbc_3_WithOutXml;

import java.util.List;
public interface StudentDao {
	
	public int insert(Student student);
	public int change(Student student);
	public int delete(int studentid);
	public Student getStudent(int studentid);
	// to return list of students from db
	public List<Student>getStudents();

}
