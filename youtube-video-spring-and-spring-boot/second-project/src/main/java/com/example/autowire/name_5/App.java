package com.example.autowire.name_5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = new ClassPathXmlApplicationContext("autowireByName.xml");
		Car car =(Car) context.getBean("mycardetails");
		car.displayDetails();

	}

}
