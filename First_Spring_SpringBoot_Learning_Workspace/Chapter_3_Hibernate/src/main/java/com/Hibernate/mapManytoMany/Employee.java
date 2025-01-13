package com.Hibernate.mapManytoMany;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="employee_details")
public class Employee {
	
	@Id
	private int employee_id;
	private String employee_name;
	
	@ManyToMany
	@JoinTable(name="emp_join_project_table")
	private List<Project> project;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int employee_id, String employee_name, List<Project> project) {
		super();
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.project = project;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", employee_name=" + employee_name + ", project=" + project
				+ "]";
	}

	

}
