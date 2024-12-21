package com.blogapp.apis.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@NoArgsConstructor
@Getter
@Setter
public class User implements UserDetails {
	/*
	 * we are implementing the UserDetails interface and its method override
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	
	@Column(unique=true)
	private String email;
	
	private String password;
	private String about;
	
	/*
	 * to maintain the mapping between post, user and category
	 */
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Post> posts = new ArrayList<Post>();
	
	/*
	 * joining between many comments for a single user
	 */
	@OneToMany(mappedBy="user",cascade= CascadeType.ALL)
	private Set<Comment> comments = new HashSet<>();
	
	/*
	 * mapping between Role and User
	 */
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="user_role",
	joinColumns=@JoinColumn(name="user",referencedColumnName="id"),
	inverseJoinColumns=@JoinColumn(name="role",referencedColumnName="id"))
	private Set<Role> roles = new HashSet<>();

	/*
	 * these are the method of UserDetails interface
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<SimpleGrantedAuthority> authories = this.roles.stream().map((role)-> 
		new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());        
		
		return authories;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		//return false;
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		//return false;
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		//return false;
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		//return false;
		return true;
	}

}
