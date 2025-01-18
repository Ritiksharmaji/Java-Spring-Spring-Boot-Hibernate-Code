package com.Assigment.repository;

import com.Assigment.entity.Admission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdmissionRepository extends JpaRepository<Admission, Long> {
    Admission findByEmail(String email);
}
