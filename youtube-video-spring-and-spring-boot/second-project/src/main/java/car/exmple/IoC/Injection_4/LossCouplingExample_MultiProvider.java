package car.exmple.IoC.Injection_4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LossCouplingExample_MultiProvider {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationIoC.xml");

        // Fetch the UserManager bean
        UserManager_multiProviderr userManager = 
        		(UserManager_multiProviderr) context.getBean("userManager_multiProvider");

        // Display details from all providers
        userManager.getUserInfo();

        // Close the Spring context
        ((ClassPathXmlApplicationContext) context).close();
    }
}
