package com.ritik.test;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ritik.beans.Student;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/ritik/resources/applicationContext.xml");
		
		// beause it will give object type so we need to types cast it of student types
		//Student std = context.getBean("");
		Student std = (Student) context.getBean("stdBean");
	
		// calling business method
		std.getStudentDetails();
	}

}
