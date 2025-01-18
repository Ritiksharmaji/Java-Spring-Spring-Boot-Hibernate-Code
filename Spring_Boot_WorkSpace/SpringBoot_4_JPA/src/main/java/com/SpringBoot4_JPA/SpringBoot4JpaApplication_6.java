package com.SpringBoot4_JPA;

import java.util.List;
import java.util.Date;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.SpringBoot4_JPA.Dao_1.UserRepository_3_jpql_1;
import com.SpringBoot4_JPA.Dao_1.UserRepository_3_jpql_2;
import com.SpringBoot4_JPA.entities_1.User;
import java.text.SimpleDateFormat;

@SpringBootApplication
public class SpringBoot4JpaApplication_6 {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBoot4JpaApplication_5.class, args);

        UserRepository_3_jpql_2 userRepo_JPQL_With_Param = context.getBean(UserRepository_3_jpql_2.class);
        
        // 1. Get all users
        List<User> allUserByJPQL = userRepo_JPQL_With_Param.getAllUser();
        System.out.println("All Users: " + allUserByJPQL);

        // 2. Find users by partial name using @Param
        List<User> usersContainingName = userRepo_JPQL_With_Param.findByNameContaining("Jo");
        System.out.println("Users with name containing 'Jo': " + usersContainingName);

        // 3. Get users ordered by name (ascending)
        List<User> orderedUsersAsc = userRepo_JPQL_With_Param.findAllUsersOrderedByNameAsc();
        System.out.println("Users ordered by name (asc): " + orderedUsersAsc);

        // 4. Count users in a specific city using @Param
        long userCount = userRepo_JPQL_With_Param.countUsersByCity("New York");
        System.out.println("Number of users in New York: " + userCount);

        // 5. Find user names and cities only (Projection)
        List<Object[]> userNamesAndCities = userRepo_JPQL_With_Param.findUserNamesAndCities();
        userNamesAndCities.forEach(obj -> System.out.println("Name: " + obj[0] + ", City: " + obj[1]));

        // 6. Delete users from a specific city using @Param
        userRepo_JPQL_With_Param.deleteUsersByCity("Los Angeles");
        System.out.println("Users from Los Angeles deleted.");

        // 7. Find users from multiple cities using @Param
        List<String> cities = List.of("New York", "Chicago", "San Francisco");
        List<User> usersInCities = userRepo_JPQL_With_Param.findUsersByCities(cities);
        System.out.println("Users from specified cities: " + usersInCities);

        // 8. Find users created after a specific date using @Param
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse("2025-01-01");
            List<User> recentUsers = userRepo_JPQL_With_Param.findUsersCreatedAfter(date);
            System.out.println("Users created after 2025-01-01: " + recentUsers);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
