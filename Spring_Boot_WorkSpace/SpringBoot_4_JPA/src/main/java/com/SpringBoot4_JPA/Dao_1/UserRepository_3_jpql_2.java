package com.SpringBoot4_JPA.Dao_1;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.SpringBoot4_JPA.entities_1.User;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

@Repository
public interface UserRepository_3_jpql_2 extends CrudRepository<User, Integer> {

    // Find users by name using @Param
    @Query("select u from User u where u.name = :name")
    List<User> findByName(@Param("name") String name);

    // Find users by city using @Param
    @Query("select u from User u where u.city = :city")
    List<User> findByCity(@Param("city") String city);

    // Find users by name and city using @Param
    @Query("select u from User u where u.name = :name and u.city = :city")
    List<User> findByNameAndCity(@Param("name") String name, @Param("city") String city);

    // JPQL query to get all users
    @Query("select u from User u")
    List<User> getAllUser();

    // Find users by name using LIKE with @Param
    @Query("select u from User u where u.name like %:name%")
    List<User> findByNameContaining(@Param("name") String name);

    // Order users by name ascending using @Param
    @Query("select u from User u order by u.name asc")
    List<User> findAllUsersOrderedByNameAsc();

    // Count users in a specific city using @Param
    @Query("select count(u) from User u where u.city = :city")
    long countUsersByCity(@Param("city") String city);

    // Find users with specific fields (name and city)
    @Query("select u.name, u.city from User u")
    List<Object[]> findUserNamesAndCities();

    // Delete users by city using @Param
    @Query("delete from User u where u.city = :city")
    @Modifying
    @Transactional
    void deleteUsersByCity(@Param("city") String city);

    // Find users by multiple cities using @Param
    @Query("select u from User u where u.city in :cities")
    List<User> findUsersByCities(@Param("cities") List<String> cities);
    
    // Find users created after a specific date using @Param
    @Query("select u from User u where u.createdAt > :date")
    List<User> findUsersCreatedAfter(@Param("date") java.util.Date date);
}
