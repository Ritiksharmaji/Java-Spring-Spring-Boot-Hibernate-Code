package com.springcore.lifecycle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
public class Test {
	public static void main(String[] args) {
		//ApplicationContext context=	new ClassPathXmlApplicationContext("com/springcore/lifeCycle/Configure_lifeCycle.xml");
		AbstractApplicationContext context=	new ClassPathXmlApplicationContext("com/springcore/lifeCycle/Configure_lifeCycle.xml");
		context.registerShutdownHook();
//		Smasha ss = (Smasha) context.getBean("s1");
//		System.out.println(ss.getPrice());
//		// to show to distroy method
//		System.out.println("--------------this is for pepsi-----------");
//		Pepsi p = (Pepsi) context.getBean("p1");
//		System.out.println(p);
//		System.out.println(p.getPrice());
		
		System.out.println("------ Example bean ---------------");
		Example e = (Example) context.getBean("exam");
		System.out.println(e);
		System.out.println(e.getSubject());
		
	}
}
