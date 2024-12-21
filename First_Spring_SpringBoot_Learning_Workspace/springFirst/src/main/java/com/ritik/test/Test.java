package com.ritik.test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ritk.beans.*;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("Configure_spring.xml");
        /*
         * The ApplicationContext interface create a context spring container.
         * 
         */
        
        Hellobean first = (Hellobean)context.getBean("student1");
        System.out.println(first);
        System.out.println(first.getString());
        System.out.println(first.getName());
	}

}
