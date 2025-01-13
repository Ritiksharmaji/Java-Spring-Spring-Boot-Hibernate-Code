package car.exmple.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationBeanContext.xml");
		
		MyBean mybean = (MyBean) context.getBean("MyBean");
		System.out.println(mybean);
		
		
	}

}
