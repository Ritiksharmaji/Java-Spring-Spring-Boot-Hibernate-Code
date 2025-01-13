package com.springcore_7.autowire.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context=	new ClassPathXmlApplicationContext("com/springcore_7/autowire/annotation/autoConfig.xml");
		
	//without typecast
	Emp employee = context.getBean("emp1",Emp.class);
	System.out.println(employee);
		
	}
}
