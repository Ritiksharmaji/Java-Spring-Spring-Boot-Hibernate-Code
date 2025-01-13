package com.example.component.annotation_9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Employee emp = context.getBean("employee", Employee.class);
		System.out.println(emp.toString());
		

	}

}
