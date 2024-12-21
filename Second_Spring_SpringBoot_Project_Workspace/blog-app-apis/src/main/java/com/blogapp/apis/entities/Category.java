package com.blogapp.apis.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="categories")
@NoArgsConstructor
@Getter
@Setter
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int category_id;
	private String category_title;
	private String category_description;
	
	/*
	 * to maintain the mapping between post, user and category
	 */
	@OneToMany(mappedBy="category",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Post> posts = new ArrayList<Post>();
	
	/*
	 * joining between many comments for a single category
	 */
	@OneToMany(mappedBy="category",cascade= CascadeType.ALL)
	private Set<Comment> comments = new HashSet<>();

}
