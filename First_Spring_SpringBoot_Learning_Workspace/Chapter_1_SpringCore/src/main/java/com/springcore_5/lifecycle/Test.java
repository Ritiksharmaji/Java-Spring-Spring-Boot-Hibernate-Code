package com.springcore_5.lifecycle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
public class Test {
	public static void main(String[] args) {
		//ApplicationContext context=	new ClassPathXmlApplicationContext("com/springcore/lifeCycle/Configure_lifeCycle.xml");
		AbstractApplicationContext context=	new ClassPathXmlApplicationContext("com/springcore_5/lifeCycle/Configure_lifeCycle.xml");		
// -------------------- this is for life-cycle of bean using the the XML ------------------------------------------------
		System.out.println("--------------this is for Smasha-----------");
		Smasha ss = (Smasha) context.getBean("s1");
		System.out.println(ss.getPrice());
		//----- to show to destroy method and this method will available in 
		//the AbstractApplicationContext so that is why we are using that 
		// interface or abstract class.
		context.registerShutdownHook();

// -------------------- this is for life-cycle of bean using the the interface ------------------------------------------------
		System.out.println("--------------this is for pepsi-----------");
		Pepsi p = (Pepsi) context.getBean("p1");
		System.out.println(p);
		System.out.println(p.getPrice());

//-----------------------this is for life-cycle of bean using the annotation ---------------------------------------------------
		System.out.println("------ this is for Example ---------------");
		Example e = (Example) context.getBean("exam");
		System.out.println(e);
		System.out.println(e.getSubject());		
	}
}



