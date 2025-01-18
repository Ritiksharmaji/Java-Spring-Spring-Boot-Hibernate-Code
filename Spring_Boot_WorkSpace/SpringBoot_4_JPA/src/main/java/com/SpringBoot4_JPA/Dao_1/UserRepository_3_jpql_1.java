package com.SpringBoot4_JPA.Dao_1;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.SpringBoot4_JPA.entities_1.User;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;

@Repository
public interface UserRepository_3_jpql_1 extends CrudRepository<User, Integer> {

    // Find users by name
    List<User> findByName(String name);

    // Find users by city
    List<User> findByCity(String city);

    // Find users by name and city
    List<User> findByNameAndCity(String name, String city);

    // JPQL query to get all users
    @Query("select u from User u")
    List<User> getAllUser();

    // Find users by name using LIKE
    @Query("select u from User u where u.name like %:name%")
    List<User> findByNameContaining(String name);

    // Order users by name ascending
    @Query("select u from User u order by u.name asc")
    List<User> findAllUsersOrderedByNameAsc();

    // Count users in a specific city
    @Query("select count(u) from User u where u.city = :city")
    long countUsersByCity(String city);

    // Find users with specific fields (name and city)
    @Query("select u.name, u.city from User u")
    List<Object[]> findUserNamesAndCities();

    // Delete users by city
    @Query("delete from User u where u.city = :city")
    @Modifying
    @Transactional
    void deleteUsersByCity(String city);

    // Find users by multiple cities
    @Query("select u from User u where u.city in :cities")
    List<User> findUsersByCities(List<String> cities);
    
    // Find users created after a specific date
    @Query("select u from User u where u.createdAt > :date")
    List<User> findUsersCreatedAfter(java.util.Date date);
}
