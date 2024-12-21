package com.blogapp.apis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.blogapp.apis.entities.Comment;


public interface CommentRepo  extends JpaRepository<Comment , Integer>{

}
