package com.ritik.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.ritik.beans.*;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
ApplicationContext context = new ClassPathXmlApplicationContext("com/ritik/resources/applicationContext.xml");
		
		HelloBean bean = (HelloBean) context.getBean("helloBean");
		
		System.out.println(bean.getname());

	}

}
