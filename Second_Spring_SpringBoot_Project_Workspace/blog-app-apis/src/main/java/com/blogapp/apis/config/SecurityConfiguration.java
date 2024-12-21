package com.blogapp.apis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.blogapp.apis.security.JwtAuthenticationEntryPoint;
import com.blogapp.apis.security.JwtAuthenticationFilter;


@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfiguration {
	
	public static final String[] PUBLIC_URLS= {
			"/api/v1/**",
			"/v3/api-docs",
			"/v2/api-docs",
			"/swagger-resources/**",
			"/swagger-ui/**",
			"/webjars/**"
	};

	 @Autowired
	    private JwtAuthenticationEntryPoint point;
	    
	    @Autowired
	    private JwtAuthenticationFilter filter;
	    
	    @Autowired
	    private UserDetailsService  userDetailsService;
	    
	    @Autowired
	    private PasswordEncoder passwordEncoder;
	    

	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

	        http.csrf(csrf -> csrf.disable())
	                .authorizeRequests().
	                requestMatchers("/home").authenticated().requestMatchers("/api/v1/login").permitAll()
//	                .requestMatchers("/api/v1/**").permitAll()
//	                .requestMatchers("/v3/api-docs").permitAll()
	                .requestMatchers(PUBLIC_URLS).permitAll()
	                .requestMatchers(HttpMethod.GET).permitAll()
	                .anyRequest()
	                .authenticated()
	                .and().exceptionHandling(ex -> ex.authenticationEntryPoint(point))
	                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
	        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
	        return http.build();
	    }
	    
	    // create a bean class to provides the authentcation with database.
	    
	    public DaoAuthenticationProvider daoAuthenticationProvider() {
	    	
	    	DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
	    	daoAuthenticationProvider().setUserDetailsService(userDetailsService);
	    	daoAuthenticationProvider().setPasswordEncoder(passwordEncoder);
	    	return daoAuthenticationProvider();
	    }
	    
	 
	    
	   
}

