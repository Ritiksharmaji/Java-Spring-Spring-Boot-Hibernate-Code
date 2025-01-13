package com.example.componentScan_8;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = new ClassPathXmlApplicationContext("ComponentScanDemo.xml");
		Employee emp = context.getBean("employee", Employee.class);
		System.out.println(emp.toString());
		

	}

}
