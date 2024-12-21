package com.springcore.stereotype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springcore.standalone.collections.Person;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context=	new ClassPathXmlApplicationContext("com/springcore/stereotype/stereotypeConfig.xml");
		//without typecast
		Student st = context.getBean("obj",Student.class);
//		System.out.println(st);
//		System.out.println(st.getAddress());
// -------- to print the location of object-------------
		System.out.println(st.hashCode());
		Student st2 = context.getBean("obj",Student.class);
		System.out.println("----- hashcode of second object -------");
		System.out.println(st2.hashCode());
		System.out.println("----- scope by xml file of teacher bean ---------");
		
	Teacher t1=	context.getBean("teacher1",Teacher.class);
	System.out.println(t1.hashCode());
	System.out.println("--second object location of teacher --------");
	Teacher t2=	context.getBean("teacher1",Teacher.class);
	System.out.println(t2.hashCode());

	}
}
