package com.springcore_4.Constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	ApplicationContext context=	new ClassPathXmlApplicationContext("com/springcore_4/Constructor/CIconfig.xml");
	Person person = (Person)context.getBean("person");
	System.out.println(person);
//	Addition addtion = (Addition) context.getBean("add");
//	addtion.RKJ_Sum();
	

	

	}

}
