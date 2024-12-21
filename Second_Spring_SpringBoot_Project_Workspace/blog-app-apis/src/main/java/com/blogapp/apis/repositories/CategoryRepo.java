package com.blogapp.apis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapp.apis.entities.Category;

public interface CategoryRepo extends JpaRepository<Category , Integer> {

}
