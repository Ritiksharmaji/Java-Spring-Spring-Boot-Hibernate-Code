package com.ritik.test;





import org.springframework.context.ApplicationContextInitializer;

import com.ritik.beans.*;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContextInitializer context = new ClassPathXmlApplicationContext("Configure_spring.xml"); 
		 HelloBean first = (HelloBean)context.getBean("student1");
	        System.out.println(first);
	        System.out.println(first.getOne());
	}

}
