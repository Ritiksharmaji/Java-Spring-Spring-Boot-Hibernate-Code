package com.ritik.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.ritik.beans.Employee;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
			// TODO Auto-generated method stub
			
			// step-1 prepare resource object first
Resource resource = new ClassPathResource("/com/ritik/resource/applicationContext.xml");
			
			// step-2 create bean factory 
			BeanFactory factory = new XmlBeanFactory(resource);
			
			Employee emp = (Employee)factory.getBean("empBean");
			// calling business method
			emp.getEmplydetals();

	}

}
