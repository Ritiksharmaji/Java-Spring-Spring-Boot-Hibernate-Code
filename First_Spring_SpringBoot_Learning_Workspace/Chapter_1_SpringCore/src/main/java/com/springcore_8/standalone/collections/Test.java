package com.springcore_8.standalone.collections;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springcore_7.autowire.annotation.Emp;

public class Test {
	public static void main(String[] args) {
	
		ApplicationContext context=	new ClassPathXmlApplicationContext("com/springcore_8/standalone/collections/aloneConfig.xml");
		
		//without typecasting
		Person person = context.getBean("person1",Person.class);
		System.out.println(person);
		System.out.println(person.getFriends().getClass().getName());
		System.out.println("------------------------");
		System.out.println(person);
		System.out.println(person.getFresstructure());
		System.out.println(person.getFresstructure().getClass().getName());
		System.out.println("------------------------");
		System.out.println(person.getProperties());

	}
}
