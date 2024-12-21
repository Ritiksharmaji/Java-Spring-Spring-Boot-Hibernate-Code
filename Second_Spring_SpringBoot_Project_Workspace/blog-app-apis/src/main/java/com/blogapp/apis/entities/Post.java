package com.blogapp.apis.entities;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="posts")
@NoArgsConstructor
@Getter
@Setter
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="post_id")
	private int postId;
	
	@Column(name="post_title")
	private String postTitle;
	
	@Column(length=1000, name="post_content")
	private String postContent;
	
	@Column(name="post_images")
	private String postImages;
	
	private Date addedDate;
	/*
	 * to maintain the mapping between user , post and category we are writing
	 * below code.
	 */
	@ManyToOne
	@JoinColumn(name="category_join_id")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="user_join_id")
	private User user;
	
	/*
	 * joining between many comments for a single post
	 */
	@OneToMany(mappedBy="post",cascade= CascadeType.ALL)
	private Set<Comment> comments = new HashSet<>();

}
