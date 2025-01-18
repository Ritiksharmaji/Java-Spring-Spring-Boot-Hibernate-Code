package com.Assigment.service;

import com.Assigment.entity.Admission;
import com.Assigment.repository.AdmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdmissionService {

    @Autowired
    private AdmissionRepository admissionRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void saveAdmission(Admission admission) {
        admission.setPassword(passwordEncoder.encode(admission.getPassword())); // Encrypt password
        Admission save = admissionRepository.save(admission);
        System.out.println("saveAdmission:"+save );
    }

    public List<Admission> getAllAdmissions() {
        return admissionRepository.findAll();
    }
}
