package car.exmple.IoC.Injection_4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LossCouplingExample {

    public static void main(String[] args) {
        // Load the Spring IoC container
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationIoC.xml");

        // Get the UserManager bean
        UserManager webServiceProvider = (UserManager) context.getBean("userManagerWithWebdataProvider");
        
     // Get the UserManager bean
        UserManager NewDataProvider = (UserManager) context.getBean("userManagerWithNewDatabaseProvider");
        
     // Get the UserManager bean
        UserManager userDataProvider = (UserManager) context.getBean("userManagerWithUserDatabaseProvider");
        
        // Call the method to get user info
        System.out.println("Web service info: " + webServiceProvider.getUserInfo());
     // Call the method to get user info
        System.out.println("New Data provider info: " + NewDataProvider.getUserInfo());
     // Call the method to get user info
        System.out.println("user Data provider info: " + userDataProvider.getUserInfo());

        // Close the Spring context
        ((ClassPathXmlApplicationContext) context).close();
    }
}
