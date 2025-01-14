package com.springcore.jdbc_2.WithXmlConfiguration;

import java.util.List;

import com.spring.jdbc.entities.Student;

public interface StudentDao {
	
	public int insert(Student student);
	public int change(Student student);
	public int delete(int studentid);
	public Student getStudent(int studentid);
	// to return list of students from db
	public List<Student>getStudents();

}
