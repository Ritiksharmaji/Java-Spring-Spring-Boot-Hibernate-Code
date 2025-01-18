package com.simple.registration.dao;

import org.springframework.data.repository.CrudRepository;
import com.simple.registration.entities.Registration;

public interface RegistrationDao extends CrudRepository<Registration, Integer> {
    Registration findById(int id);
}
