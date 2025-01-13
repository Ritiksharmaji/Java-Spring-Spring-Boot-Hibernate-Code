package com.example.autowire.Constructor_7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = new ClassPathXmlApplicationContext("autowireByConstrutor.xml");
		Car car =(Car) context.getBean("mycardetails");
		car.displayDetails();

	}

}
