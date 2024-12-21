package com.springcore.removeXMl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Test {

	public static void main(String[] args) {
		ApplicationContext context=	new AnnotationConfigApplicationContext(JavaConfig.class);
		Student st = context.getBean("temp",Student.class);
		System.out.println(st);
		st.study();
	}

}
