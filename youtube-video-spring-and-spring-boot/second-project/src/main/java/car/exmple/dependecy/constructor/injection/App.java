package car.exmple.dependecy.constructor.injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContructorInject.xml");
		
		
		Car car =(Car) context.getBean("mycardetails");
		car.displayDetails();

	}

}
