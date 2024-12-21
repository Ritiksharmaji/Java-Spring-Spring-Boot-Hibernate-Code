package com.blogapp.apis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapp.apis.entities.Role;

public interface RoleRepo extends JpaRepository<Role,Integer> {

}
