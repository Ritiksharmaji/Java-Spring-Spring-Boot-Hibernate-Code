package com.SpringBoot4_JPA;

import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.SpringBoot4_JPA.Dao_1.UserRepository_2_CustomFInderMethod_1;
import com.SpringBoot4_JPA.Dao_1.UserRepository_3_jpql_1;
import com.SpringBoot4_JPA.entities_1.User;

@SpringBootApplication
public class SpringBoot4JpaApplication_3 {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBoot4JpaApplication_3.class, args);

        UserRepository_2_CustomFInderMethod_1 userRepo = context.getBean(UserRepository_2_CustomFInderMethod_1.class);
        
        UserRepository_3_jpql_1 userRepo_JPQL = context.getBean(UserRepository_3_jpql_1.class);

        // Find users by name
        List<User> usersByName = userRepo.findByName("John Doe");
        System.out.println("Users with name ' John Doe':");
        usersByName.forEach(System.out::println);
        
        // find all user details
        List<User> allUser_ByJPQL = userRepo_JPQL.getAllUser();
        System.out.println(allUser_ByJPQL);
    }
}
