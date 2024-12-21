package com.spring.orm.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.orm.hibernate5.HibernateTemplate;
import com.spring.orm.entities.Student;

public class StudentDao {
	
	// declare HibernateTemplate class
	HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Transactional
	// to perform the write operation
	public int insert(Student student) {
		// to insert data into database
		// to insert data into database it use the HibernateTemplate object
		Integer save =(Integer)this.hibernateTemplate.save(student);
		return save;
		
	}
	// get a single record based on id
	public Student fetStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class,studentId );
		return student;
	}
	// get all student
	public List<Student> getAllStudent(){
		List<Student> all = this.hibernateTemplate.loadAll(Student.class);
		return all;
	}
	
	// delete the data.
	@Transactional
	public void deleteStudent(int studentId) {
		// loading the data
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		// deleting the student object
		this.hibernateTemplate.delete(student);
	}
	// updating the data.
	@Transactional
	public void UpdateStudent(Student student) {
		
		this.hibernateTemplate.update(student);
	}

}
