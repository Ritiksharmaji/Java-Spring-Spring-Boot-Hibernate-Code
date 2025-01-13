package com.springcore_3.Ref;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Reference {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore_3/Ref/config.xml"); 
		
		A aObject = (A)context.getBean("aref");
		System.out.println(aObject.getX());
		System.out.println(aObject.getOb().getY());
		System.out.println(aObject);
		
	}

}
