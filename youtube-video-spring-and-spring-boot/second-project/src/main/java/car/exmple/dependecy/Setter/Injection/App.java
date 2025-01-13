package car.exmple.dependecy.Setter.Injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationSetterInject.xml");

        Car car = (Car) context.getBean("mycardetails");
        car.displayDetails();
    }
}
