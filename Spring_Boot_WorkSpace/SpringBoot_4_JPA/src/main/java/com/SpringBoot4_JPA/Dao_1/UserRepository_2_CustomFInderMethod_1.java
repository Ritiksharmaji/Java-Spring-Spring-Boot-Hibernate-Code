package com.SpringBoot4_JPA.Dao_1;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.SpringBoot4_JPA.entities_1.User;

@Repository
public interface UserRepository_2_CustomFInderMethod_1 extends CrudRepository<User, Integer> {
    List<User> findByName(String name);
}
