package com.springcore_6.autowire.XML;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context=	new ClassPathXmlApplicationContext("com/springcore_6/autowire/XML/autoConfig.xml");
		
	//without typecast
	Emp employee = context.getBean("emp1",Emp.class);
	System.out.println(employee);
		
		
	}

}