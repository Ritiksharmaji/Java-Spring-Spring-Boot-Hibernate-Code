package com.springcore.collections;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
public class Test {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/collections/ritik.xml");             
		
		Emp emp1 = (Emp) context.getBean("emp1");
		
		
		System.out.println("Employe name:"+emp1.getName());
		System.out.println("Employe phone_No:"+emp1.getPhones());
		System.out.println("Employe Address:"+emp1.getAddresses());
		System.out.println("Employe Course:"+emp1.getCourses());
		
	}

}
