package com.springORM.SpringORM;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class App 
{
	 public static void main( String[] args )
	    {
	        System.out.println( "Hello World!" );
	        ApplicationContext context=	new ClassPathXmlApplicationContext("springHbConfig.xml");
//	        Student st = new Student(235,"Adil khan","Guntur");
//	        StudentDao bean = context.getBean("studentDao",StudentDao.class);
//	        int insert = bean.insert(st);
//	        System.out.println(insert);  
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	       boolean go = true;
	        while(go) {
	        	
	        	System.out.println("press-1: for add new Student");
		        System.out.println("press-2: for display all Student");
		        System.out.println("press-3: for get details a Student");
		        System.out.println("press-4: for delete a Student");
		        System.out.println("press-5: for update a Student");
		        System.out.println("press-6: for  exit");
		        
		        try {
		        	
		        	int input = Integer.parseInt(br.readLine());
		        	if(input == 1) {
		        		// add new student
		        	}else if(input == 2) {
		        		// display all student
		        	}else if(input == 3) {
		        		// display a student
		        	}else if(input == 4) {
		        		//delete a student
		        	}else if(input == 5) {
		        		// update a student
		        	}else if(input == 6) {
		        		go = false;
		        	}else {
		        		go = false;
		        	}
		        	
		        }catch(Exception e) {
		        	System.out.println("try with other");
		        	System.out.println(e.getMessage());
		        }
	        }
	         
	    }
}
