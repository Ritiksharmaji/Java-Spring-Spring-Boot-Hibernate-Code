package com.springcore.jdbc_2.WithXmlConfiguration;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("program is start....");
        // spring jdbc=> jdbcTemplate
      
        ApplicationContext context=	new ClassPathXmlApplicationContext("com/springcore/jdbc_2/WithXmlConfiguration/config.xml");       
        StudentDao temp =  context.getBean("studentDao1",StudentDao.class);
        
        Student student = new Student();
//------------------------ insert method to insert the data into database.. ---------------------------------------------------
		//student.setId(104);
		//student.setName("rahul kumar");
		//student.setCity("hasanpura");
		//int insertData = temp.insert(student);
		//System.out.println("student inserted: "+ insertData);
        
//-------------------------- update method to update the data into database ------------------------------------------------------
//        student.setId(104);
//        student.setName("rahul sharma");
//        student.setCity("ushri");
//	    int updatedData = temp.change(student);
//	    System.out.println("student Updated: "+ updatedData);
	    
//-------------------------- delete method to delete a data into database ------------------------------------------------------
//	    int deletedData = temp.delete(104);
//	    System.out.println("student Deleted: "+ deletedData);
	   

//-------------------------- delete method to delete a data into database ------------------------------------------------------
//	    int deletedData = temp.delete(104);
//	    System.out.println("student Deleted: "+ deletedData);

//-------------------------- display single record from the database ------------------------------------------------------
//         student = temp.getStudent(102);
//	    System.out.println("student details of roll-no 102 is: "+ student);

        
//-------------------------- display all  record from the database ------------------------------------------------------
     // for selecting multiple record
        List<Student> sts = temp.getStudents();
        for(Student s: sts) {
        	System.out.println(s);
        }
    }
}



