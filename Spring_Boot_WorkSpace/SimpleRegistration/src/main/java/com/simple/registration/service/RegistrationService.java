package com.simple.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.registration.dao.RegistrationDao;
import com.simple.registration.entities.Registration;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationDao registrationDao;

    public Registration saveRegistration(Registration registration) {
        return registrationDao.save(registration);
    }

    public Registration findRegistrationById(int id) {
        return registrationDao.findById(id);
    }
}
