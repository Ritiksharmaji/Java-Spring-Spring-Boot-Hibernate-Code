package com.Hibernate.mapManytoMany;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="project_details")
public class Project {
	@Id
	private int project_id;
	private String project_title;
	
	@ManyToMany(mappedBy="project")
	private List<Employee> employee;

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(int project_id, String project_title, List<Employee> employee) {
		super();
		this.project_id = project_id;
		this.project_title = project_title;
		this.employee = employee;
	}

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public String getProject_title() {
		return project_title;
	}

	public void setProject_title(String project_title) {
		this.project_title = project_title;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Project [project_id=" + project_id + ", project_title=" + project_title + ", employee=" + employee
				+ "]";
	}
	

}
