package com.springcore.spEL;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ApplicationContext context=	new ClassPathXmlApplicationContext("com/springcore/spEL/seELConfig.xml");
		//without typecast
		Demo d1 = context.getBean("demo",Demo.class);
		System.out.println(d1);
		System.out.println("----------------------");
		System.out.println(d1.getZ());
		
	}

}
