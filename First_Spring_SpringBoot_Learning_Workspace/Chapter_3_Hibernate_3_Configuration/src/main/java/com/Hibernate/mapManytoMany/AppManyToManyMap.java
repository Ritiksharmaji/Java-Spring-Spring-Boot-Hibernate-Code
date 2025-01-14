package com.Hibernate.mapManytoMany;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AppManyToManyMap {

	public static void main(String[] args) {
		
		 Configuration cfg = new Configuration();
	     cfg.configure("hiberante.cfg.xml");
	     SessionFactory factory = cfg.buildSessionFactory();
	     System.out.println(factory);
//--------------setting details for Employee class and Project class---------------------------------
	     Employee ep1 = new Employee();
	     Employee ep2 = new Employee();
	     
	     ep1.setEmployee_id(101);
	     ep1.setEmployee_name("Ritik sharma ji");
	     
	     ep2.setEmployee_id(102);
	     ep2.setEmployee_name("Ankit Bhaiya sharma");
	     
	     Project pro = new Project();
	     Project pro2 = new Project();
	     
	     pro.setProject_id(501);
	     pro.setProject_title("Time Managment System");
	     
	     pro2.setProject_id(502);
	     pro2.setProject_title("Blog application using Full stack");
	     
	     // creating array to store the 
	     List<Employee> Emp_List = new ArrayList<Employee>();
	     List<Project> Pro_List = new ArrayList<Project>();
	     
	     // adding object of employee and project to list object
	     Emp_List.add(ep1);
	     Emp_List.add(ep2);
	     
	     Pro_List.add(pro);
	     Pro_List.add(pro2);
//---------------setting project details to employee and employee details to Project---------------------
	     // setting employee-1 to all details of project
	     ep1.setProject(Pro_List);
	     // setting project-2 to all details of all employee
	     pro2.setEmployee(Emp_List);
	     
	     
	     // getting session
	      Session session = factory.openSession();
	      // to start the transaction
	      Transaction beginTransaction = session.beginTransaction();
	      // to save the transcation(changed)
	      session.save(pro);
	      session.save(pro2);
	      session.save(ep1);
	      session.save(ep2);
	      
//	      System.out.println(Emp_List);
//	      System.out.println(Pro_List);
	      // to commit the database changed
	      beginTransaction.commit();
	      // close the connection
	      session.close(); 

	}

}
